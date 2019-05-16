package ru.artemagaev.testproject;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import ru.artemagaev.testproject.entity.Book;
import ru.artemagaev.testproject.service.BookService;
import ru.artemagaev.testproject.service.BookServiceImpl;

import java.util.Map;

@SpringBootApplication
public class TestprojectApplication implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private BookServiceImpl bookService;


	@Override
	public void run(String... args){
		bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
		bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
		bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

		//fuzzey search
		Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));

		//List<Book> books = bookService.findByTitle("Elasticsearch Basics");

		books.forEach(x -> System.out.println(x));
	}


	public static void main(String[] args) {
		SpringApplication.run(TestprojectApplication.class, args);
	}


//	@Override


//	//useful for debug, print elastic search details
//	private void printElasticSearchInfo() {
//
//		System.out.println("--ElasticSearch--");
//		Client client = es.getClient();
////		Map<String, String> asMap = client.settings().keySet();
//		client.settings().
////		asMap.forEach((k, v) -> {
////			System.out.println(k + " = " + v);
////		});
//		System.out.println("--ElasticSearch--");
//	}
}

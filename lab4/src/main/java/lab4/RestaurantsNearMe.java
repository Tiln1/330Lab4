package lab4;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class RestaurantsNearMe {

	MongoClient client;
	MongoCollection<Document> collection;
	MongoDatabase db;
	
	public static void main(String[] args) {
		RestaurantsNearMe n = new RestaurantsNearMe();
		n.run();
	}
	
	public void run(){
		client = new MongoClient();
		db = client.getDatabase("test");
		collection = db.getCollection("restaurants");
		
		MongoCursor<Document> resultIterator = filter("grades.grade", "A");
		while(resultIterator.hasNext()){
			System.out.println(resultIterator.next());
		}
	}
	
	public MongoCursor<Document> filter(String property, String value){
		return collection.find(Filters.eq(property, value)).iterator();
	}

}

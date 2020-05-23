package kkp2.controlbackend.Service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import kkp2.controlbackend.Bean.DBStatus;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import com.mongodb.MongoClient; //legacy

@Service
public class MongoDBService {

    private static MongoClient mgc = MongoClients.create("mongodb://detectivelemon.com:27017");
    private static MongoDatabase mgdb = mgc.getDatabase("kkp2");

//    public static final String pub = "2187435847,420787754";
//    public static final String pri = "364556556,1188588638";
//    public static final int bitLength = 32;

    public DBStatus getDBStatus(){
        DBStatus r = new DBStatus();
        Document doc = new Document();
        doc.append("serverStatus", 1);
        Document runCommand = mgdb.runCommand(doc);
        r.setHost(runCommand.getString("host"));
        r.setVersion(runCommand.getString("version"));
        r.setUptime(runCommand.getDouble("uptime"));
        JSONObject jsonObject = JSONObject.parseObject(runCommand.toJson());
        JSONObject t = jsonObject.getJSONObject("connections");
        r.setConnections_active(t.getInteger("active"));
        r.setConnections_current(t.getInteger("current"));
        r.setConnections_available(t.getInteger("available"));
        r.setConnections_totalCreated(t.getInteger("totalCreated"));
        t = jsonObject.getJSONObject("network");
        r.setBytesIn(t.getJSONObject("bytesIn").getDouble("$numberLong"));
        r.setBytesOut(t.getJSONObject("bytesOut").getDouble("$numberLong"));
        return r;
    }

    public static void main(String[] args) {
        //连接服务端
        MongoClient mgc = MongoClients.create("mongodb://detectivelemon.com:27017");
//        MongoClient mgc = new MongoClient("127.0.0.1", 27017); //legacy
        System.out.println("server connected");

        //连接数据库
        MongoDatabase mgdb = mgc.getDatabase("kkp2");
        System.out.println("db connected");

        //连接集合
//        MongoCollection<Document> collection = mgdb.getCollection("raw_data");
//        System.out.println("collection connected");

        //插入文档
//        Document doc = new Document("name", "李四")
//                .append("id", "33010320201016662")
//                .append("data_a", 2000)
//                .append("data-b", 3000)
//                .append("index", 2)
//                .append("result", "");
//        collection.insertOne(doc);
//        System.out.println("insert successful");

        //查询index最大
//        Document doc = collection.find().sort(new BasicDBObject("index", -1)).first();
//        System.out.println(doc);
//        int index = doc.getInteger("index");

        //批量插入
//        int n = 200;
//        Random random = new Random();
//        RandomInfo r = new RandomInfo();
//        List<Document> docs = new ArrayList<Document>();
//        Document tmp;
//        for (int i = 1; i <=n ; i++) {
//            int A = 150 + random.nextInt(1550);//150-1700 个人公积金月缴额
//            int B = 305 + random.nextInt(1220);//305-1525 个人社保缴费基数
//            BigInteger bigIntegerA = new BigInteger(String.valueOf(A));
//            BigInteger bigIntegerB = new BigInteger(String.valueOf(B));
//            bigIntegerA = Pailler.encrypt(bigIntegerA, pub, bitLength);
//            bigIntegerB = Pailler.encrypt(bigIntegerB, pub, bitLength);
//            String a = bigIntegerA.toString();
//            String b = bigIntegerB.toString();
//            System.out.println("A="+A+" encry="+a+" decry="+Pailler.decrypt(new BigInteger(a), pub, pri));
//            tmp = new Document("name", r.getRandomName())
//                    .append("id_num", r.getRandomID())
//                    .append("data_a", a)
//                    .append("data_b", b)
//                    .append("index", index + i);
//            docs.add(tmp);
//            System.out.println(tmp);
//        }
//        collection.insertMany(docs);
//

        //查询指令，serverStatus指令下connections对象。1代表取出数据，9不取出
        Document doc = new Document();
        doc.append("serverStatus", 1);
        Document runCommand = mgdb.runCommand(doc);
        System.out.println(runCommand.get("network"));
        System.out.println(runCommand.get("connections"));


        //关闭连接
        mgc.close();
    }

}

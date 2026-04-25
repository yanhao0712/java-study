/// 饿汉式
/*
public class DBConnectionPool {

    private DBConnectionPool(){}
        private static DBConnectionPool instance = new DBConnectionPool() ;
    public static DBConnectionPool getInstance(){
        return instance;
        }}

*/




 class TextSingleton{
    public static void main(String[] args){
        DBConnectionPool pool1 = DBConnectionPool.getInstance();
        DBConnectionPool pool2 = DBConnectionPool.getInstance();
        System.out.println(pool1 == pool2);
    }
}


///懒汉式
public class DBConnectionPool {
    private DBConnectionPool(){

    }
    private static DBConnectionPool instance;
    public static DBConnectionPool getInstance(){
        if(instance == null){
            instance = new DBConnectionPool();
        }
        return instance;
    }


}



















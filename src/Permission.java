import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    String value();

}



class GameServer {
    public GameServer() {

    }
    @Permission("admin")
    public void saveData(){
        System.out.println("保存");

    }
    @Permission("user")
    public void playGame(){
        System.out.println("加载");
    }
}


 class MyGameRunner{
    public static void main(String[] args)  throws Exception {
        GameServer game = new GameServer();
        Class <?> cla =game.getClass();
        Method [] ms = cla.getDeclaredMethods();
        for (Method m : ms) {
            if (m.isAnnotationPresent(Permission.class)) {
                Permission perm = m.getAnnotation(Permission.class);
                if(perm.value().equals("admin")){
                    System.out.println("权限不足");
                    game.saveData();
                    m.invoke(game);
                }
                if(perm.value().equals("user")){
                    System.out.println("准许");
                    game.playGame();
                    m.invoke(game);
                }
            }
        }


    }
}

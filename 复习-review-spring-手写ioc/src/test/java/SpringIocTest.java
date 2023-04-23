import org.junit.Test;

public class SpringIocTest {

    @Test
    public void testClassPackage() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.limu.review.domain.People");
        System.out.println(aClass.getPackage().getName());
    }
}

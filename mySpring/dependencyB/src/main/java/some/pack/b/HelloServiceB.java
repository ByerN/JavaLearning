package some.pack.b;

import com.byern.app.springapp.mavendi.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by ByerN on 25.06.2017.
 */

@Service
public class HelloServiceB implements HelloService {

    @Override
    public String getMessage() {
        return "Hi from " + this.toString();
    }

}

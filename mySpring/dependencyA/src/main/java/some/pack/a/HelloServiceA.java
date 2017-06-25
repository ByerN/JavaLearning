package some.pack.a;

import com.byern.app.springapp.mavendi.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by ByerN on 25.06.2017.
 */

@Service
public class HelloServiceA implements HelloService {

    @Override
    public String getMessage() {
        return "Hi from " + this.toString();
    }

}

package Service;

import org.restlet.ext.odata.Generator;

public class MyGenerator {

	public static void main(String[] args) {
		Generator generator = new Generator("http://localhost:54613/Service.svc/");
        
        try {
            generator.generate("./src/");
        }catch(Exception x) {
            System.out.println(x);
        }


	}

}

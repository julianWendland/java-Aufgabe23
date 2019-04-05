/**
 * Created by Classdumper, User Peter Heusch
 * Creation Date: 02.04.2019 09:18:47
 */

package aufgabe_23;


import java.io.InputStream;
import java.io.Reader;


public class Parser {
    static {
        System.err.println("Please call injectClass(\"aufgabe_23.Parser\"), you've imported a skeleton");
    }

    Scanner scanner;

    public Parser(InputStream arg02) {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Parser(Reader arg02) {
        // Roughly 1 lines of implementation
       this.scanner = new Scanner(arg02);
    }

    public Float number() {
        // Roughly 9 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Float term() {
        // Roughly 7 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Float factor() {
        // Roughly 7 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Float expression() {
        // Roughly 15 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }
}


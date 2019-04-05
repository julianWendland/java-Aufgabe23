/**
 * Created by Classdumper, User Peter Heusch
 * Creation Date: 02.04.2019 09:18:47
 */
package aufgabe_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scanner {

    static {
        System.err.println("Please call injectClass(\"aufgabe_23.Scanner\"), you've imported a skeleton");
    }

    private Reader reader;
    private Token nextToken;
    private Object nextValue;

    public Scanner(InputStream arg02) {
        this.reader = new InputStreamReader(arg02);

    }

    public Scanner(Reader arg02) {
        // Roughly 3 lines of implementation
        this.reader = new BufferedReader(arg02);
        this.nextToken = null;
        this.nextValue = null;

    }

    private int getChar() throws IOException {
        return this.reader.read();
    }

    Object getValue() {
        // Roughly 1 lines of implementation
        return this.nextValue;

    }

    void scanToken() {
        // Roughly 44 lines of implementation
        try {
            int nextchar = getChar();
            switch (nextchar) {
                case -1:
                    this.nextToken = null;
                    this.nextValue = null;
                    return;
                case '+':
                    this.nextToken = Token.PLUS;
                    return;
                case '-':
                    this.nextToken = Token.MINUS;
                    return;
                case '/':
                    this.nextToken = Token.SLASH;
                    return;
                case '*':
                    this.nextToken = Token.STAR;
                    return;
                case '(':
                    this.nextToken = Token.OPEN;
                    return;
                case ')':
                    this.nextToken = Token.CLOSE;
                    return;
                case ';':
                    this.nextToken = Token.END;
                    return;
                case ' ':

                    scanToken();
                    return;

            }
            if (Character.isDigit(nextchar)) {
                StringBuilder number = new StringBuilder();
                number.append((char) nextchar);

                while (Character.isDigit(nextchar = peekChar())) {
                    number.append((char) nextchar);
                    getChar();
                    
                }
                if ((nextchar = peekChar()) == '.') {
                    getChar();
                    number.append((char) nextchar);

                    while (Character.isDigit(nextchar = peekChar())) {
                        getChar();
                        number.append((char) nextchar);
                    }
                    
                }

                if ((nextchar = peekChar()) == 'E' || (nextchar=peekChar())=='e') {
                    getChar();
                    number.append((char) nextchar);
                    if ((nextchar = peekChar()) == '-') {
                        getChar();
                        number.append((char) nextchar);
                    }
                    if (!Character.isDigit(nextchar = peekChar())) {
                        throw new IllegalArgumentException("Illegal float number");
                    }

                    while (Character.isDigit(nextchar = peekChar())) {
                        getChar();
                        number.append((char) nextchar);
                    }
                    
                    

                } 

                this.nextValue = Float.valueOf(number.toString());
                this.nextToken = Token.NUMBER;
                return;
            } else{
                  throw new IllegalArgumentException("Illegal input character \"=\"");
            }

          
        } catch (IOException e) {
            Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    Token getToken() {
        // Roughly 2 lines of implementation
        if (this.nextToken == null) {
            this.scanToken();
        }
        Token token = peekToken();
        this.nextToken = null;
        return token;

    }

    Token peekToken() {
        // Roughly 1 lines of implementation
        if (nextToken == null) {
            this.scanToken();
        }
        return this.nextToken;

    }

    Object peekValue() {
        // Roughly 1 lines of implementation
        return this.nextValue;

    }

    private int peekChar() throws IOException {
        int ch;
        this.reader.mark(1);
        ch = this.reader.read();
        this.reader.reset();
        return ch;
    }

    int readChar(boolean reset) throws IOException {
        if (reset) {
            reader.mark(1);
        }
        int r = reader.read();
        if (reset) {
            reader.mark(1);
        }
        return r;
    }

}

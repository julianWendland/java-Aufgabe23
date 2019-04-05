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
import java.io.UncheckedIOException;

public class Scanner {

    private Reader reader;
    private Token nextToken;
    private Object nextValue;

    public Scanner(InputStream arg02) {
       this(new InputStreamReader(arg02));

    }

    public Scanner(Reader arg02) {
        // Roughly 3 lines of implementation
        this.reader = new BufferedReader(arg02);
        this.nextToken = null;
        this.nextValue = null;
        try {
            reader.mark(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getChar() throws IOException {
        return readChar(false);
    }

    Object getValue() {
        // Roughly 1 lines of implementation
        return this.nextValue;

    }

   void scanToken() {
        // Roughly 44 lines of implementation
        try {
            int nextchar = getChar();
            while(Character.isWhitespace(nextchar)){
                nextchar =getChar();
            }
            
            switch (nextchar) {
                case -1:
                    this.nextToken=null;
                    this.nextValue=null;
                    return;
                case '+':
                    this.nextToken = Token.PLUS;
                   return;
                    
                case '-':
                    this.nextToken =Token.MINUS;
                   return;
                    
                case '/':
                    this.nextToken = Token.SLASH;
                   return;
                    
                case '*':
                    this.nextToken = Token.STAR;
                    return ;
                    
                case '(':
                     this.nextToken = Token.OPEN;
                   return;
                    
                case ')':
                     this.nextToken = Token.CLOSE;
                   return;
                    
                case ';':
                     this.nextToken = Token.END;
                    return;
                    
            }
               
            if (Character.isDigit(nextchar)) {
                StringBuilder number = new StringBuilder();
                number.append((char) nextchar);

                while (Character.isDigit(peekChar())) {
                    nextchar =getChar();
                    number.append((char) nextchar);
                    
                    
                    
                }
                if (( peekChar()) == '.') {
                   nextchar = getChar();
                    number.append((char) nextchar);

                    while (Character.isDigit( peekChar())) {
                       nextchar = getChar();
                        number.append((char) nextchar);
                    }
                    
                }

                if (peekChar() == 'e' || peekChar() == 'E') {
                    // read e
                     nextchar = getChar();
                    // Add e
                    number.append((char) nextchar);

                    if (peekChar() == '-') {
                        // read minus
                        nextchar = getChar();
                        number.append((char) nextchar);
                    }

                   

                   
                    // read all numbers after 'e'
                    while (Character.isDigit( peekChar())  ) {
                        
                        
                        // read current number
                        nextchar = getChar();
                    

                        // if not end of input
                      
                            // add current char
                            number.append((char) nextchar);
                        
                    }
                    if (!Character.isDigit(nextchar) || peekChar() == '.' || peekChar() == 'e' || peekChar() == 'E') {
                        throw new IllegalArgumentException("Illegal float number");
                    }
                    

                } 

               this.nextValue = Float.valueOf(number.toString());
               this.nextToken = Token.NUMBER;
                return;
                 
                 
                
            } else{
                  throw new IllegalArgumentException("Illegal input character \"=\"");
            }
            
            
          
        } catch (IOException e) {
           throw new UncheckedIOException(e);
        }

    }


    Token getToken() {
        // Roughly 2 lines of implementation

        Token token = peekToken();
        nextToken = null;
        return token;

    }

    Token peekToken() {
        // Roughly 1 lines of implementation
        if (nextToken == null) {
            scanToken();
        }
        return nextToken;

    }

    Object peekValue() {
        // Roughly 1 lines of implementation
        return this.nextValue;

    }

    private int peekChar() throws IOException {
        return readChar(true);
    }

     int readChar(boolean reset) throws IOException {      
        reader.mark(1);
        int r = reader.read();
         if (reset) {
            reader.reset();
        }                           
        return r;
    }
}
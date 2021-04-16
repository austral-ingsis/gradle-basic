import exceptions.BadTokenException;
import handler.*;
import java.io.IOException;
import java.util.*;
import stream.CharacterStream;
import token.Token;

public class PrintScriptLexer implements Lexer {
  private static final List<TokenHandler> handlers =
      new LinkedList<>() {
        {
          push(new StringTokenHandler());
          push(new IdentifierTokenHandler());
          push(new NumberTokenHandler());
          push(new FunctionNameTokenHandler());
          push(new NumberTypeTokenHandler());
          push(new StringTypeTokenHandler());
          push(new VariableKeywordTokenHandler());
          push(new RightParenthesesTokenHandler());
          push(new LeftParenthesesTokenHandler());
          push(new ColonTokenHandler());
          push(new EqualsTokenHandler());
          push(new DivisionOperatorTokenHandler());
          push(new MultiplicationOperatorTokenHandler());
          push(new PlusOperatorTokenHandler());
          push(new EscCharTokenHandler());
          push(new EndOfLineTokenHandler());
        }
      };

  private transient List<Token> tokens;

  @Override
  public List<Token> lex(String statement) throws BadTokenException {
    tokens = new ArrayList<>();
    CharacterStream stream = new CharacterStream(statement);
    generateTokens(stream);
    return tokens;
  }

  private void generateTokens(CharacterStream stream)
      throws BadTokenException { // agregar multiples espacios
    Token currentToken =
        getNextToken(stream).orElseThrow(() -> new BadTokenException("Invalid token"));

    while (stream.hasNext()) {
      tokens.add(currentToken);
      currentToken = getNextToken(stream).orElseThrow(() -> new BadTokenException("Invalid token"));
    }
  }

  private Optional<Token> getNextToken(CharacterStream stream) {
    return handlers.stream()
        .map(
            tokenHandler -> {
              try {
                return tokenHandler.handle(stream);
              } catch (IOException e) {
                throw new RuntimeException("IO Error");
              }
            })
        .filter(Optional::isPresent)
        .findFirst()
        .orElse(Optional.empty());
  }
}

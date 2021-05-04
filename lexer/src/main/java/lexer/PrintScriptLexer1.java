package lexer;

import exceptions.BadTokenException;
import handler.*;
import java.util.*;
import java.util.stream.Collectors;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class PrintScriptLexer1 implements Lexer {
  private static final List<TokenHandler> handlers =
      new LinkedList<>() {
        {
          push(new FunctionNameTokenHandler());
          push(new StringTypeTokenHandler());
          push(new NumberTypeTokenHandler());
          push(new VariableKeywordTokenHandler());
          push(new StringTokenHandler());
          push(new IdentifierTokenHandler());
          push(new NumberTokenHandler());
          push(new RightParenthesesTokenHandler());
          push(new LeftParenthesesTokenHandler());
          push(new ColonTokenHandler());
          push(new EqualsTokenHandler());
          push(new DivisionOperatorTokenHandler());
          push(new MultiplicationOperatorTokenHandler());
          push(new DivisionOperatorTokenHandler());
          push(new MinusOperatorTokenHandler());
          push(new PlusOperatorTokenHandler());
          push(new EscCharTokenHandler());
          push(new SpaceTokenHandler());
        }
      };

  private transient List<Token> tokens;

  @Override
  public List<Token> lex(String statement) throws BadTokenException {
    tokens = new ArrayList<>();
    CharacterStream stream = new CharacterStream(statement);
    generateTokens(stream);
    return tokens.stream()
        .filter(token -> token.getType() != TokenType.SPACE_CHAR)
        .collect(Collectors.toList());
  }

  private void generateTokens(CharacterStream stream) throws BadTokenException {
    while (stream.shouldRead()) {
      Token currentToken =
          getNextToken(stream).orElseThrow(() -> new BadTokenException("Invalid token"));
      tokens.add(currentToken);
    }
  }

  private Optional<Token> getNextToken(CharacterStream stream) {
    return handlers.stream()
        .map(tokenHandler -> tokenHandler.handle(stream))
        .filter(Optional::isPresent)
        .findFirst()
        .orElse(Optional.empty());
  }
}

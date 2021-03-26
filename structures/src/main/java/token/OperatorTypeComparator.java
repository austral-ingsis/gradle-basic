package token;

import java.util.Comparator;

public class OperatorTypeComparator implements Comparator<TokenType> {
    @Override
    public int compare(TokenType o1, TokenType o2) {
        return o1.getPrecedence() - o2.getPrecedence();
    }
}

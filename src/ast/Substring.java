package ast;

public class Substring implements Ast {
    
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visit(this);
        }
    
        public Ast stringArg;
        public Ast intArg1;
        public Ast intArg2;
        public String functName = "substring";
    
        public Substring(Ast stringArg, Ast intArg1, Ast intArg2) {
            this.stringArg = stringArg;
            this.intArg1 = intArg1;
            this.intArg2 = intArg2;
        }
    
}

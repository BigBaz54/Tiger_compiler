package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ast.*;
import controlSem.varUndefined;
import types.*;

public class SymboleTableVisitor implements AstVisitor<Void> {

    private SymboleTableList symboleTableList;
    private SymboleTable currentSymboleTable;
    private TypeFactory typeFactory;

    public SymboleTableVisitor() {
        symboleTableList = new SymboleTableList();
        typeFactory = new TypeFactory();
        currentSymboleTable = null;
    }

    public void print(){
        symboleTableList.print();
    }

    @Override
    public Void visit(Program program) {
        currentSymboleTable = new SymboleTable();
        symboleTableList.add(currentSymboleTable);
        program.child.accept(this);
        return null;
    }

    @Override
    public Void visit(LValueDot lValueDot) {
        lValueDot.accessed.accept(this);
        lValueDot.exp.accept(this);
        return null;
    }

    @Override
    public Void visit(LValueBrack lValueBrack) {
        lValueBrack.accessed.accept(this);
        lValueBrack.exp.accept(this);
        return null;
    }

    @Override
    public Void visit(LValue lValue) {
        
        return null;
    }

    @Override
    public Void visit(Exp exp) {
        if(exp.id!=null) {
            exp.id.accept(this);
            Type leftType = currentSymboleTable.lookupTypeVar(exp.id.name);
            if (leftType==null) {
                System.out.println("[SEM] Variable "+exp.id.name+" is not defined");
                return null;
            }
        }
        if(exp.lvalue!=null)
            exp.lvalue.accept(this);
        exp.orExp.accept(this);
        if ((exp.orExp instanceof Id) && ((currentSymboleTable.lookupTypeVar(((Id)exp.orExp).name))==null)) {
            System.out.println("[SEM] Variable "+((Id)exp.orExp).name+" is not defined");
        } else if ((exp.orExp instanceof TypeExp)){
            Type orType = ((((TypeExp)exp.orExp).getType(currentSymboleTable, typeFactory)));
            if (exp.id != null && orType!=null) {
                Type leftType = currentSymboleTable.lookupTypeVar(exp.id.name);
                if (!(leftType.equals(orType))) {
                    System.out.println("[SEM] Type mismatch : "+leftType+" was expected but "+orType+" was provided");
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(OrExp orExp) {
        orExp.gauche.accept(this);
        orExp.droite.accept(this);
        return null;
    }

    @Override
    public Void visit(AndExp andExp) {
        andExp.gauche.accept(this);
        andExp.droite.accept(this);
        return null;
    }

    @Override
    public Void visit(CompExp compExp) {
        compExp.plusExpL.accept(this);
        compExp.plusExpR.accept(this);
        return null;
    }

    @Override
    public Void visit(PlusExp plusExp) {
        plusExp.gauche.accept(this);
        plusExp.droite.accept(this);
        return null;
    }

    @Override
    public Void visit(TimesExp timesExp) {
        timesExp.gauche.accept(this);
        timesExp.droite.accept(this);
        return null;
    }

    @Override
    public Void visit(Nill nill) {
        
        return null;
    }

    @Override
    public Void visit(Break Breack) {
        
        return null;
    }

    @Override
    public Void visit(SeqExp seqExp) {
        for(Ast ast : seqExp.seqExp1) {
            ast.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Negation negation) {
        negation.exp.accept(this);
        return null;
    }

    @Override
    public Void visit(IdExp idExp) {
        idExp.id.accept(this);
        if (currentSymboleTable.lookupTypeFun(idExp.id.name)==null) {
            System.out.println("[SEM] Function "+idExp.id.name+" is not defined");
            return null;
        }
        if(idExp.expList!=null) {
                int expectedNb = currentSymboleTable.getNbArg(idExp.id.name);
                if (idExp.expList.get(0) instanceof AstList) {
                    int givenNb = ((AstList) idExp.expList.get(0)).getList().size();
                    if (givenNb != expectedNb) {
                        System.out.println("[SEM] Function "+idExp.id.name+" expected "+expectedNb+" arguments but "+givenNb+" were given");
                        return null;
                    }
                }
            
            for(Ast ast : idExp.expList) {
                ast.accept(this);
                int nbParam = ((AstList) ast).getList().size();
                ArrayList<Type> expectedTypes = currentSymboleTable.getArgTypes(idExp.id.name);
                boolean error = false;
                for (int i=0; i<nbParam; i++) {
                    Type expected = expectedTypes.get(i);
                    Type given = ((TypeExp) ((AstList) ast).getList().get(i)).getType(currentSymboleTable, typeFactory);
                    if (!(expected).equals(given)) {
                        System.out.println("[SEM] Function "+idExp.id.name+" expected type "+expected.toString()+" for argument "+(i+1)+" but type "+given.toString()+" was given");
                        error = true;
                    }
                }
                if (error == true) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(ArrayCreate ArrayCreate) {
        
        return null;
    }

    @Override
    public Void visit(IfThenElse ifThenElse) {
        ifThenElse.condition.accept(this);
        ifThenElse.thenBlock.accept(this);
        if (ifThenElse.elseBlock!=null){
            ifThenElse.elseBlock.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(While while1) {
        while1.cond.accept(this);
        while1.body.accept(this);
        return null;
    }

    @Override
    public Void visit(For for1) {
        for1.id.accept(this);
        for1.init.accept(this);
        for1.cond.accept(this);
        return null;
    }

    @Override
    public Void visit(Let let) {
        for(Ast ast : let.decs) {
            ast.accept(this);
        }
        for(Ast ast : let.body) {
            ast.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(TyDec tyDec) {
        tyDec.id.accept(this);
        tyDec.right.accept(this);

        if (tyDec instanceof TyDecRecord) {
            TyDecRecord tyDecRecord = (TyDecRecord) tyDec;
            String name = tyDecRecord.id.name;
            if (typeFactory.getType(name)!=null) {
                System.out.println("[SEM] Type "+name+" already declared");
                return null;
            }
            Map<String, Type> fields = new HashMap<String, Type>();
            for (Tuple field:((FieldList) tyDecRecord.right).list) { // On crée sa liste de champs
                String fieldType = ((Id) field.value2).name;
                fields.put(field.value1.name, typeFactory.getType(fieldType));
            }
            types.RecordType recordType = new types.RecordType(name, fields);
            typeFactory.addType(name, recordType);  // On ajoute le type dans la table des types

        }

        if (tyDec instanceof TyDecArray) {
            TyDecArray tyDecArray = (TyDecArray) tyDec;
            String name = tyDecArray.id.name;
            if (typeFactory.getType(name)!=null) {
                System.out.println("[SEM] Type "+name+" already declared");
                return null;
            }
            String type = ((Id) tyDecArray.right).name;
            ArrayType arrayType = new ArrayType(name, typeFactory.getType(type),0);
            typeFactory.addType(name, arrayType);  // On ajoute le type dans la table des types
        }

        if (tyDec instanceof TyDecId) {
            TyDecId tyDecId = (TyDecId) tyDec;
            String name = tyDecId.id.name;
            if (typeFactory.getType(name)!=null) {
                System.out.println("[SEM] Type "+name+" already declared");
                return null;
            }
            String type = ((Id) tyDecId.right).name;
            types.Type idType = typeFactory.getType(type);
            typeFactory.addType(name, idType);  // On ajoute le type dans la table des types
        }

        return null;
    }

    @Override
    public Void visit(List l) {
        for(Tuple tuple : l.list) {
            tuple.value1.accept(this);
            tuple.value2.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunDec funDec) {
        // Ajout dans la TDS mère (seulement si une fonction n'est pas déjà nommée pareil)
        String name = funDec.id.name;
        if (currentSymboleTable.lookupTypeFun(name)==null) {

            ArrayList<Type> paramTypes = new ArrayList<>();
            for (Tuple tuple : funDec.params.list) {
                paramTypes.add(typeFactory.getType(((Id) tuple.value2).name));
            }
            Type returnType = typeFactory.getType(funDec.returnType.name);
            int nbParams = funDec.params.getSize();
            SymboleTableEntry funcEntry = new FunctionEntry(name, paramTypes, returnType, nbParams, 0);
            currentSymboleTable.insert(funcEntry);
            SymboleTable oldSymboleTable = currentSymboleTable;
            
            // Ajout des params dans la TDS fille
            SymboleTable newSymboleTable = new SymboleTable(currentSymboleTable);
            symboleTableList.add(newSymboleTable);
            currentSymboleTable = newSymboleTable;
            for (Tuple tuple : funDec.params.list) {
                currentSymboleTable.insert(new VariableEntry(tuple.value1.name, typeFactory.getType(((Id) tuple.value2).name), 0, 0));
            }
    
            // Visite du corps de la fonction
            funDec.body.accept(this);
    
            // On repasse sur la table mère
            currentSymboleTable = oldSymboleTable;
        } else {
            System.out.println("[SEM] Function "+name+" already declared");
        }

        return null;
    }

    @Override
    public Void visit(FunDecType funDecType) {
        
        return null;
    }

    @Override
    public Void visit(AstList params) {
        for (Ast ast : params.list) {
            ast.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VarDec varDec) {
        boolean error = false;
        String name;
        Type leftType;
        Type rightType = ((TypeExp) varDec.right).getType(currentSymboleTable, typeFactory);
        new varUndefined(varDec.right, currentSymboleTable);
        if (varDec.left instanceof Id) {
            // Cas où le type n'est pas précisé
            name = (((Id) varDec.left).name);
            if (currentSymboleTable.lookupTypeVar(name)!=null) {
                System.out.println("[SEM] Variable "+name+" already declared");
                error = true;
            }
            if (rightType==null) {
                error = true;
            }
            if (varDec.right instanceof ArrayExp) {
                if (Integer.valueOf(((ArrayExp) varDec.right).expList.get(0).toString())<=0) {
                    System.out.println("[SEM] Array size must be positive");
                    error = true;
                }
            }
            if (error == true) {
                return null;
            }

            if (varDec.right instanceof ArrayExp) {
                currentSymboleTable.insert(new VariableEntry(name, rightType, 0, Integer.parseInt(((ArrayExp) varDec.right).expList.get(1).toString())));
            } else {
                currentSymboleTable.insert(new VariableEntry(name, rightType, 0, 0));
            }
        } else {
            // Cas où le type est précisé
            name = ((VarType) varDec.left).id.name;
            if (currentSymboleTable.lookupTypeVar(name)!=null) {
                System.out.println("[SEM] Variable "+name+" already declared");
                error = true;
            }
            leftType = typeFactory.getType(((VarType) varDec.left).type.name);
            
            if (leftType != null) {
                if (!(leftType.equals(rightType))) {
                    System.out.println("[SEM] Type mismatch : "+leftType+" was expected but "+rightType+" was provided");
                }
            } else {
                System.out.println("[SEM] Type "+((VarType) varDec.left).type.name+" is not defined");
                error = true;
            }
            if (varDec.right instanceof ArrayExp) {
                if (Integer.valueOf(((ArrayExp) varDec.right).expList.get(0).toString())<=0) {
                    System.out.println("[SEM] Array size must be positive");
                    error = true;
                }
            }
            if (error == true) {
                return null;
            }

            if (varDec.right instanceof ArrayExp) {
                currentSymboleTable.insert(new VariableEntry(name, rightType, 0, Integer.parseInt(((ArrayExp) varDec.right).expList.get(1).toString())));
            } else {
                currentSymboleTable.insert(new VariableEntry(name, rightType, 0, 0));
            }
        }
        return null;
    }

    @Override
    public Void visit(VarDecType varDecNoType) {
        
        return null;
    }

    @Override
    public Void visit(VarType varType) {
        varType.id.accept(this);
        varType.type.accept(this);
        return null;
    }

    @Override
    public Void visit(Id id) {
        return null;
    }

    @Override
    public Void visit(IntLit intLit) {
        
        return null;
    }

    @Override
    public Void visit(StringLit str) {
        
        return null;
    }

    @Override
    public Void visit(Print print) {
        
        return null;
    }

    @Override
    public Void visit(Flush flush) {
        
        return null;
    }

    @Override
    public Void visit(GetChar getChar) {
        
        return null;
    }

    @Override
    public Void visit(Ord ord) {
        
        return null;
    }

    @Override
    public Void visit(Chr chr) {
        
        return null;
    }

    @Override
    public Void visit(Size size) {
        
        return null;
    }

    @Override
    public Void visit(Substring substring) {
        
        return null;
    }

    @Override
    public Void visit(Concat concat) {
        
        return null;
    }

    @Override
    public Void visit(Not not) {
        
        return null;
    }

    @Override
    public Void visit(Exit exit) {
        
        return null;
    }

    @Override
    public Void visit(LValueExp lValueExp) {
        
        return null;
    }
}

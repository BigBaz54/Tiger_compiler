package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ast.*;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Exp exp) {
        if(exp.id!=null)
            exp.id.accept(this);
        if(exp.lvalue!=null)
            exp.lvalue.accept(this);
        exp.orExp.accept(this);
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Break Breack) {
        // TODO Auto-generated method stub
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
        if(idExp.expList!=null)
            for(Ast ast : idExp.expList) {
                ast.accept(this);
            }
        return null;
    }

    @Override
    public Void visit(ArrayCreate ArrayCreate) {
        // TODO Auto-generated method stub
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
            String type = ((Id) tyDecArray.right).name;
            types.ArrayType arrayType = new types.ArrayType(name, typeFactory.getType(type),0);
            typeFactory.addType(name, arrayType);  // On ajoute le type dans la table des types
        }

        if (tyDec instanceof TyDecId) {
            TyDecId tyDecId = (TyDecId) tyDec;
            String name = tyDecId.id.name;
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
        SymboleTable newSymboleTable = new SymboleTable(currentSymboleTable);
        currentSymboleTable = newSymboleTable;
        symboleTableList.add(currentSymboleTable);

        // Visiteur
        funDec.id.accept(this);
        funDec.params.accept(this);
        funDec.body.accept(this);
        if(funDec.returnType!=null)
            funDec.returnType.accept(this);
            
        // Remplissage de la table des symboles
        String name = funDec.id.name;
        List params = (List) funDec.params;
        ArrayList<Type> listOfParameter = new ArrayList<Type>();
        for (Tuple param:params.list) {
            String type = ((Id) param.value2).name;
            listOfParameter.add(typeFactory.getType(type));
        }
        if (funDec.returnType != null) {
            Type type = typeFactory.getType(funDec.returnType.name);
            SymbolTableEntry entry = new FunctionEntry(name,listOfParameter , type, params.getSize());
            currentSymboleTable.insert(entry);
        } else {
            Type type = new VoidType();
            SymbolTableEntry entry = new FunctionEntry(name,listOfParameter ,type , params.getSize());
            currentSymboleTable.insert(entry);
        }
        return null;
    }

    @Override
    public Void visit(FunDecType funDecType) {
        // TODO Auto-generated method stub
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
        return null;
    }

    @Override
    public Void visit(VarDecType varDecNoType) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(IntLit intLit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(StringLit str) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Print print) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Flush flush) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(GetChar getChar) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Ord ord) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Chr chr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Size size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Substring substring) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Concat concat) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Not not) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(Exit exit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visit(LValueExp lValueExp) {
        // TODO Auto-generated method stub
        return null;
    }
}

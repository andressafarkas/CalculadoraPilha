import java.util.ArrayList;

public class Calculadora {

    // Realiza os cálculos das operações
    public double ResParcial(double a, double b, String operacao){
        double res = 0;
        if(operacao.equals("+")){
            res = a + b;
        }else  if(operacao.equals("-")){
            res = a - b;
        }else  if(operacao.equals("*")){
            res = a * b;
        }else  if(operacao.equals("/")){
            res = a / b;
        }else if(operacao.equals("^")){
            res = Math.pow(a, b);
        }
        return res;
    }

    // Verifica se os operandos são números
    public boolean IsNumber(String a, String b){
        try {
            Double.parseDouble(b);
            Double.parseDouble(a);
            return true;
            }catch(NumberFormatException e) {
                return false;
            }  
        }

    public String Calcula(ArrayList l){
        Pilha p = new Pilha();
        int tam_max = 0;
        double resposta = 0;
        double operandoA;
        String operacao;
        double operandoB;

        for (int i = 0; i < l.size(); i++) {
            // enquanto for diferente de "fecha", adiciona na fila
            if(!l.get(i).equals(")") && !l.get(i).equals("]") && !l.get(i).equals("}")){
                p.push((String) l.get(i));
            }else if(l.get(i).equals(")")){ // se for igual a ')'
                String b = p.pop();
                operacao = p.pop();
                String a = p.pop();
                if(!IsNumber(b, a)){ // chama o método para validar se os operandos estão corretos
                    return ("Erro de sintaxe encontrado! Existem operadores para os quais não foram encontrados operandos.");
                }else if(!(operacao.equals("+")) && (operacao.equals("-")) && (operacao.equals("*")) && (operacao.equals("/")) && (operacao.equals("^"))){
                    return("Erro de Sintaxe encontrado. Erro de operador!");
                }else if(p.top().equals("(")){ // compara o caracter de abre com o fecha
                    p.pop();  // remove o caracter de abre
                    operandoB =  Double.parseDouble(b); // converte o operando pra numero
                    operandoA = Double.parseDouble(a);
                    resposta = ResParcial(operandoA, operandoB, operacao); // faz o calculo
                    p.push(Double.toString(resposta)); // adiciona a resposta na pilha
                    if(tam_max < p.size()){ // atualiza o tamanho maximo da pilha
                        tam_max = p.size();
                    }
                }else{
                    return("Erro de sintaxe encontrado! Pares de definição de prioridades incorretos.");
                }  
            }else if(l.get(i).equals("]")){  // se for igual a ']'
                String b = p.pop();
                operacao = p.pop();
                String a = p.pop();
                if(!IsNumber(b, a)){ // chama o método para validar se os operandos estão corretos
                    return ("Erro de sintaxe encontrado! Existem operadores para os quais não foram encontrados operandos.");
                }else if(!(operacao.equals("+")) && (operacao.equals("-")) && (operacao.equals("*")) && (operacao.equals("/")) && (operacao.equals("^"))){
                    return("Erro de Sintaxe encontrado. Erro de operador!");
                }else if(p.top().equals("[")){ // compara o caracter de abre com o fecha
                    p.pop();  // remove o caracter de abre
                    operandoB =  Double.parseDouble(b);  // converte o operando pra numero
                    operandoA = Double.parseDouble(a);
                    resposta = ResParcial(operandoA, operandoB, operacao); // faz o calculo
                    p.push(Double.toString(resposta)); // adiciona a resposta na pilha
                    if(tam_max < p.size()){ // atualiza o tamanho maximo da pilha
                        tam_max = p.size();
                    }
                }else{
                    return("Erro de sintaxe encontrado! Pares de definição de prioridades incorretos.");
                } 
            }else if(l.get(i).equals("}")){ // se for igual a '}'
                String b = p.pop();
                operacao = p.pop();
                String a = p.pop();
                if(!IsNumber(b, a)){ // chama o método para validar se os operandos estão corretos
                    return ("Erro de sintaxe encontrado! Existem operadores para os quais não foram encontrados operandos.");
                }else if(!(operacao.equals("+")) && (operacao.equals("-")) && (operacao.equals("*")) && (operacao.equals("/")) && (operacao.equals("^"))){
                    return("Erro de Sintaxe encontrado. Erro de operador!");
                }else if(p.top().equals("{")){ // compara o caracter de abre com o fecha
                    p.pop();  // remove o caracter de abre 
                    operandoB =  Double.parseDouble(b); // converte o operando pra numero
                    operandoA = Double.parseDouble(a);
                    resposta = ResParcial(operandoA, operandoB, operacao);  // faz o calculo
                    p.push(Double.toString(resposta)); // adiciona a resposta na pilha
                    if(tam_max < p.size()){ // atualiza o tamanho maximo da pilha
                        tam_max = p.size();
                    }
                }else{
                    return ("Expressão Inválida!");
                }
            }
        }
        if(p.size() == 1){ // se o tamanho da pilha for 1, retorna o topo (resultado das operações)
            return("Resposta: " + p.top() + "\nTamanho máximo da pilha: " + tam_max);
        }else{
            return("");
        }
    }
}
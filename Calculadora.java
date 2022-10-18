import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

public class Calculadora {

    Pilha p = new Pilha();

    public double Res_parcial(double a, double b, String operacao){
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
        }else{
            System.out.println("Erro de Sintaxe encontrado. Expressão lógica não encontrada!");
        }
        return res;
    }

    public String Calcula(ArrayList l){
        int tam_max = 0;
        double resposta = 0;
        double operandoA;
        String operacao;
        double operandoB;

        // enquanto for diferente de "fecha", adiciona na fila
            for (int i = 0; i < l.size(); i++) {
                if(!l.get(i).equals(")") || !l.get(i).equals("]") || !l.get(i).equals("}")){
                    p.push((String) l.get(i));
                }
                if(l.get(i + 1).equals(")")){
                    l.remove(i + 1); // remove do array o caracter de fecha
                    String b = p.pop();
                    String op = p.pop();
                    String a = p.pop();
                    if(p.top().equals("(")){
                        p.pop();  // remove o caracter de abre
                        operandoB = Double.parseDouble(b);
                        operacao = op;
                        operandoA = Double.parseDouble(a);
                        resposta = Res_parcial(operandoA, operandoB, operacao);
                        p.push(Double.toString(resposta));
                        if(tam_max < p.size()){
                            tam_max = p.size();
                        }
                    }else{
                        System.out.println("1 - Erro de sintaxe encontrado. Pares de definição de prioridades incorretos!");
                        break;
                    }
                }if(l.get(i + 1).equals("]")){
                    l.remove(i + 1);
                    String b = p.pop();
                    String op = p.pop();
                    String a = p.pop();
                    if(p.top().equals("[")){
                        p.pop();  // remove o caracter de abre
                        operandoB = Double.parseDouble(b);
                        operacao = op;
                        operandoA = Double.parseDouble(a);
                        resposta = Res_parcial(operandoA, operandoB, operacao);
                        p.push(Double.toString(resposta));
                        if(tam_max < p.size()){
                            tam_max = p.size();
                        }
                    }else{
                        System.out.println("2 - Erro de sintaxe encontrado. Pares de definição de prioridades incorretos!");
                        break;
                    } 
                }if (l.get(i + 1).equals("}")){
                    l.remove(i + 1);
                    String b = p.pop();
                    String op = p.pop();
                    String a = p.pop();
                    if(p.top().equals("{")){
                        p.pop();  // remove o caracter de abre
                        operandoB = Double.parseDouble(b);
                        operacao = op;
                        operandoA = Double.parseDouble(a);
                        resposta = Res_parcial(operandoA, operandoB, operacao);
                        p.push(Double.toString(resposta));
                        if(tam_max < p.size()){
                            tam_max = p.size();
                        }
                    }else{
                        System.out.println("3 - Erro de sintaxe encontrado. Pares de definição de prioridades incorretos!");
                        break;
                    }
                }
            }
            String resultado2 = ("Resposta: " + p.top());
            String resultado3 = (" Tamanho máximo da pilha: " + tam_max);

        return (resultado2 + resultado3);
             
    }
}


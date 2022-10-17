import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

public class Calculadora {

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
        } if(operacao.equals("^")){
            res = Math.pow(a, b);
        }else{
            System.out.println("Erro de sintaxe encontrado. Operação matemática inválida!");
        }
        return res;
    }

    Pilha p = new Pilha();

    public double Calcula(ArrayList l){
        Pilha aux = new Pilha();
        int tam = l.size();
        int tam_aux = aux.size();
        double resposta;
        String operacao;

        for (int i = 0; i < tam; i++) {  // adiciona a expressao na fila
            p.push((String)l.get(i));
        }

        while (p.size() != 1){  // enquanto o tam da fila for diferente de 1
            if (p.top().equals("}")){
                aux.push(p.pop()); // adiciona } na fila aux
                if(p.top().equals("]")){
                    aux.push(p.pop());  // adiciona ] na fila auxiliar
                }else if (p.top().equals(")")){ // adiciona ) na fila auxiliar
                    aux.pop(); // remove o ultimo ')'
                    int a = Integer.parseInt(p.pop());
                    operacao = p.pop();
                    int b = Integer.parseInt(p.pop());
                    resposta = Res_parcial(a, b, operacao);
                    p.pop();  // remove o caracter de abertura
                    p.push(Double.toString(resposta));  // adiciona o resultado parcial na fila auxiliar
                }
                
                for (int i = 0; i < tam_aux; i++) {
                    p.push(aux.pop());  // retorna os elementos pra pilha principal com o resultado calculado
                } 

            }else if (p.top().equals("]")){
                aux.push(p.pop()); // adiciona ] na fila aux
                if(p.top().equals(")")){
                    aux.push(p.pop());  // adiciona ) na fila auxiliar
                }else{
                    aux.pop(); // remove o ultimo ')'
                    int a = Integer.parseInt(p.pop());
                    operacao = p.pop();
                    int b = Integer.parseInt(p.pop());
                    resposta = Res_parcial(a, b, operacao);
                    p.pop();  // remove o caracter de abertura
                    p.push(Double.toString(resposta));  // adiciona o resultado parcial na fila auxiliar
                }
                for (int i = 0; i < tam_aux; i++) {
                    p.push(aux.pop());  // retorna os elementos pra pilha principal com o resultado calculado
                } 

            }else if(p.top().equals(")")){
                p.pop();  // remove ) 
                int a = Integer.parseInt(p.pop());
                operacao = p.pop();
                int b = Integer.parseInt(p.pop());
                resposta = Res_parcial(a, b, operacao);
                p.pop();  // remove o caracter de abertura
                p.push(Double.toString(resposta));

            }else{
                if (p.size() != 1){  // se o tamanho da pilha for diferente de 1
                    System.out.println("Erro de sintaxe encontrado!");
                    break;
                }else{
                    return Double.parseDouble(p.top());
                }
            }
        }
        return Double.parseDouble(p.top());
    }
}

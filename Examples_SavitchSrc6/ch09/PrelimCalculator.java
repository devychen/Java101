
import java.util.Scanner;

/**
 PRELIMINARY VERSION without exception handling.
 Simple line-oriented calculator program. The class
 can also be used to create other calculator programs.
*/
public class PrelimCalculator
{
    private double result;
    private double precision = 0.0001; // Numbers this close to zero are
                                       // treated as if equal to zero.

    public static void main(String[] args) throws DivideByZeroException,
                                                  UnknownOpException
    {
        PrelimCalculator clerk = new PrelimCalculator( );
        System.out.println("Calculator is on.");
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");
        clerk.doCalculation();
		
        System.out.println("The final result is " +
						   clerk.getResult( ));
        System.out.println("Calculator program ending.");
    }
    public PrelimCalculator( )
    {
        result = 0;
    }
    public void reset( )
    {
        result = 0;
    }

    public void setResult(double newResult)
    {
        result = newResult;
    }
    public double getResult( )
    {
        return result;
    }

    public void doCalculation( ) throws DivideByZeroException,
                                        UnknownOpException
    {
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        result = 0;
        System.out.println("result = " + result);

        while (!done)
        {
           char nextOp = (keyboard.next( )).charAt(0);
            if ((nextOp == 'e') || (nextOp == 'E'))
                done = true;
            else
            {
                double nextNumber = keyboard.nextDouble( );
                result = evaluate(nextOp, result, nextNumber);
                System.out.println("result " + nextOp + " " +
                                    nextNumber + " = " + result);
                System.out.println("updated result = " + result);
            }
        }
    }

    /**
     Returns n1 op n2, provided op is one of '+', '-', '*',or '/'.
     Any other value of op throws UnknownOpException.
    */
    public double evaluate(char op, double n1, double n2)
               throws DivideByZeroException, UnknownOpException
    {
        double answer;
        switch (op)
        {
            case '+':
                answer = n1 + n2;
                break;
            case '-':
                answer = n1 - n2;
                break;
            case '*':
                answer = n1 * n2;
                break;
            case '/':
                if ((-precision < n2) && (n2 < precision))
                    throw new DivideByZeroException( );
                answer = n1 / n2;
                break;
            default:
                throw new UnknownOpException(op);
       }
       return answer;
    }
}





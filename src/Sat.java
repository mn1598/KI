import org.sat4j.core.VecInt;
import org.sat4j.maxsat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import java.util.Arrays;

public class Sat {
    public static void main(String[] args) {
        final int MAXVAR = 21;
        final int NBCLAUSES = 55;

        ISolver solver = SolverFactory.newDefault();

// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
        solver.newVar(MAXVAR);
        solver.setExpectedNumberOfClauses(NBCLAUSES);
// Feed the solver using Dimacs format, using arrays of int
// (best option to avoid dependencies on SAT4J IVecInt)
        /*
        for (int i=0;i<NBCLAUSES;i++) {
            int [] clause = // get the clause from somewhere
                    // the clause should not contain a 0, only integer (positive or negative)
                    // with absolute values less or equal to MAXVAR
                    // e.g. int [] clause = {1, -3, 7}; is fine
                    // while int [] clause = {1, -3, 7, 0}; is not fine
                    try {
                        solver.addClause(new VecInt(clause)); // adapt Array to IVecInt
                    } catch (ContradictionException e) {
                        e.printStackTrace();
                    }
        }

         */

        try {
            //Typ 1 Klauseln:
            solver.addClause(new VecInt(new int[]{-1, -4}));
            solver.addClause(new VecInt(new int[]{-2, -5}));
            solver.addClause(new VecInt(new int[]{-3, -6}));
            solver.addClause(new VecInt(new int[]{-1, -7}));
            solver.addClause(new VecInt(new int[]{-2, -8}));
            solver.addClause(new VecInt(new int[]{-3, -9}));

            solver.addClause(new VecInt(new int[]{-4, -7}));
            solver.addClause(new VecInt(new int[]{-5, -8}));
            solver.addClause(new VecInt(new int[]{-6, -9}));
            solver.addClause(new VecInt(new int[]{-4, -10}));
            solver.addClause(new VecInt(new int[]{-5, -11}));
            solver.addClause(new VecInt(new int[]{-6, -12}));

            solver.addClause(new VecInt(new int[]{-7, -10}));
            solver.addClause(new VecInt(new int[]{-8, -11}));
            solver.addClause(new VecInt(new int[]{-9, -12}));
            solver.addClause(new VecInt(new int[]{-7, -13}));
            solver.addClause(new VecInt(new int[]{-8, -14}));
            solver.addClause(new VecInt(new int[]{-9, -15}));
            solver.addClause(new VecInt(new int[]{-7, -16}));
            solver.addClause(new VecInt(new int[]{-8, -17}));
            solver.addClause(new VecInt(new int[]{-9, -18}));

            solver.addClause(new VecInt(new int[]{-10, -13}));
            solver.addClause(new VecInt(new int[]{-11, -14}));
            solver.addClause(new VecInt(new int[]{-12, -15}));

            solver.addClause(new VecInt(new int[]{-13, -16}));
            solver.addClause(new VecInt(new int[]{-14, -17}));
            solver.addClause(new VecInt(new int[]{-15, -18}));

            //Typ 2 Klauseln:
            solver.addClause(new VecInt(new int[]{1, 2, 3}));
            solver.addClause(new VecInt(new int[]{4, 5, 6}));
            solver.addClause(new VecInt(new int[]{7, 8, 9}));
            solver.addClause(new VecInt(new int[]{10, 11, 12}));
            solver.addClause(new VecInt(new int[]{13, 14, 15}));
            solver.addClause(new VecInt(new int[]{16, 17, 18}));
            solver.addClause(new VecInt(new int[]{19, 20, 21}));

            // Typ 3 Klauseln
            solver.addClause(new VecInt(new int[]{-1, -2}));
            solver.addClause(new VecInt(new int[]{-1, -3}));
            solver.addClause(new VecInt(new int[]{-2, -3}));

            solver.addClause(new VecInt(new int[]{-4, -5}));
            solver.addClause(new VecInt(new int[]{-4, -6}));
            solver.addClause(new VecInt(new int[]{-5, -6}));

            solver.addClause(new VecInt(new int[]{-7, -8}));
            solver.addClause(new VecInt(new int[]{-7, -9}));
            solver.addClause(new VecInt(new int[]{-8, -9}));

            solver.addClause(new VecInt(new int[]{-10, -11}));
            solver.addClause(new VecInt(new int[]{-10, -12}));
            solver.addClause(new VecInt(new int[]{-11, -12}));

            solver.addClause(new VecInt(new int[]{-13, -14}));
            solver.addClause(new VecInt(new int[]{-13, -15}));
            solver.addClause(new VecInt(new int[]{-14, -15}));

            solver.addClause(new VecInt(new int[]{-16, -17}));
            solver.addClause(new VecInt(new int[]{-16, -18}));
            solver.addClause(new VecInt(new int[]{-17, -18}));

            solver.addClause(new VecInt(new int[]{-19, -20}));
            solver.addClause(new VecInt(new int[]{-19, -21}));
            solver.addClause(new VecInt(new int[]{-20, -21}));
        } catch (ContradictionException e) {
            e.printStackTrace();
        }
// we are done. Working now on the IProblem interface
        IProblem problem = solver;
        try {
            if (problem.isSatisfiable()) {
                int model[] = problem.findModel();
                System.out.println(Arrays.toString(model));
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

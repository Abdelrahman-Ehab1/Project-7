import Modes.ThreeThreadsValdator;
import Modes.TwentySevenThreadsValdator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    long start = System.nanoTime();
//new ThreeThreadsValdator();
    new TwentySevenThreadsValdator();
    long end = System.nanoTime();

    System.out.println("Time taken: " + (end - start)/1_000_000 + " ms");
    }


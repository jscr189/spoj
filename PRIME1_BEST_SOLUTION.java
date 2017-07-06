package spoj;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

public class PRIME1_BEST_SOLUTION {
	public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PRIME1 solver = new PRIME1();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
 
    static class PRIME1 {
        public void solve(int testNumber, InputReader sc, PrintWriter pw) {
            long low = sc.nextLong();
            long high = sc.nextLong();
 
            if (high > (long) 1e6) {
                int limit = (int) Math.sqrt(high);
 
                boolean primes[] = new boolean[limit + 1];
                primes[0] = true;
                primes[1] = true;
 
                for (int i = 2; i * i < primes.length; i++) {
                    if (!primes[i]) {
                        for (int j = i * i; j < primes.length; j += i) {
                            primes[j] = true;
                        }
                    }
                }
                boolean primes2[] = new boolean[(int) (high - low + 1)];
                Arrays.fill(primes2, true);
                for (int i = 2; i < primes.length; i++) {
                    if (!primes[i]) {
                        long lowLim = (low / i) * i;
                        if (lowLim < low) {
                            lowLim += i;
                        }
                        //pw.println(i + " " + lowLim);
                        for (long j = lowLim; j < high; j += i) {
                            primes2[(int) (j - low)] = false;
                        }
                    }
                }
                for (long i = low; i < high; i++) {
                    if (primes2[(int) (i - low)]) {
                        pw.println(i);
                    }
                }
                pw.println();
            } else {
                boolean primes[] = new boolean[(int) 1e6 + 1];
                primes[0] = true;
                primes[1] = true;
 
                for (int i = 2; i * i < primes.length; i++) {
                    if (!primes[i]) {
                        for (int j = i * i; j < primes.length; j += i) {
                            primes[j] = true;
                        }
                    }
                }
                for (long i = low; i <= high; i++) {
                    if (!primes[(int) i]) {
                        pw.println(i);
                    }
                }
                pw.println();
            }
        }
 
    }
 
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
 
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
 
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next() {
            return readString();
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
 
        }
 
    }
}

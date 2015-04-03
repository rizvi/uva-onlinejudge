/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersystem;

/**
 *
 * @author Masudul Haque
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Acm10044 {

    public static final String INFINITY = "infinity";
    static final String ERDOS = "Erdos, P.";
    static Map< String, Author> index = new HashMap< String, Author>();

    static class Author {
        int distance = -1;
        boolean visited;
        String name;
        Set< Author> coauthors = new HashSet< Author>();

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Author)) {
                return false;
            }

            Author author = (Author) o;
            return this.name.equals(author.name);
        }

        public Author(String name) {
            this.name = name;
        }

        public String getErdosNumber() {
            if (distance == -1) {
                return name + " " + INFINITY;
            } else {
                return name + " " + distance;
            }
        }
    }

    // credits for this routine go to http://blog.csdn.net/metaphysis/article/details/6432247
    private static List< String> extractAuthors(String paperDesc) {
        paperDesc = paperDesc.substring(0, paperDesc.indexOf(":"));
        List< String> names = new ArrayList< String>();
        int begin = 0;
        int end = paperDesc.indexOf(".,", begin);

        while (end != -1) {
            names.add(paperDesc.substring(begin, end + 1));
            begin = end + 3;
            end = paperDesc.indexOf(".,", begin);
        }

        if (begin < (paperDesc.length() - 1)) {
            names.add(paperDesc.substring(begin));
        }

        return names;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //final BufferedReader in = new BufferedReader(new FileReader("in_test.txt"));

        int numScenarios = Integer.parseInt(in.readLine().trim());
        for (int scenario = 1; scenario <= numScenarios; scenario++) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            int numPapers = Integer.parseInt(st.nextToken());
            int numAuthors = Integer.parseInt(st.nextToken());

            String[][] allAuthors = new String[numPapers][];
            for (int paper = 0; paper < numPapers; paper++) {
                List< String> paperAuthors = extractAuthors(in.readLine().trim());
                allAuthors[paper] = paperAuthors.toArray(
                        new String[paperAuthors.size()]);
            }

            String[] authors = new String[numAuthors];
            for (int author = 0; author < numAuthors; author++) {
                authors[author] = in.readLine();
            }

            computeErdosNumbers(allAuthors);

            StringBuilder builder = new StringBuilder();
            builder.append("Scenario " + scenario);
            builder.append("\n");
            for (int i = 0; i < numAuthors; i++) {
                Author indexedAuthor = index.get(authors[i]);
                if (indexedAuthor == null) { // author not in the list of papers
                    // show default infinity erdos number
                    builder.append(new Author(authors[i]).getErdosNumber());
                } else {
                    // show pre-calculated erdos number
                    builder.append(indexedAuthor.getErdosNumber());
                }

                if (i < numAuthors - 1) {
                    builder.append("\n");
                }
            }
            System.out.println(builder.toString());
        }
    }

    public static void computeErdosNumbers(String[][] paperAuthors) {
        // built collaboration graph using adjacency lists
        buildAdjacencyList(paperAuthors);

        // perform exhaustive BFS search on the entire collaboration graph
        Queue< Author> q = new LinkedList< Author>();
        Author root = index.get(ERDOS);
        root.distance = 0;
        q.add(root);
        root.visited = true;

        while (!q.isEmpty()) {
            Author current = q.remove();
            Iterator< Author> coauthors = current.coauthors.iterator();
            while (coauthors.hasNext()) {
                Author coauthor = coauthors.next();
                if (!coauthor.visited) {
                    coauthor.distance = current.distance + 1;
                    coauthor.visited = true;
                    q.add(coauthor);
                }
            }
        }
    }

    private static void buildAdjacencyList(String[][] paperAuthors) {
        index.clear();
        for (int i = 0; i < paperAuthors.length; i++) {
            process(paperAuthors[i]);
        }
    }

    private static void process(String[] collaborators) {
        for (int i = 0; i < collaborators.length; i++) {
            String name = collaborators[i];
            Author author = index.get(name);
            if (author == null) {
                author = new Author(name);
                index.put(author.name, author);
            }
            for (int j = 0; j < collaborators.length; j++) {
                if (!author.name.equals(collaborators[j])) {
                    Author coauthor = index.get(collaborators[j]);
                    if (coauthor == null) {
                        coauthor = new Author(collaborators[j]);
                        index.put(coauthor.name, coauthor);
                    }
                    author.coauthors.add(coauthor);
                }
            }
        }
    }
}
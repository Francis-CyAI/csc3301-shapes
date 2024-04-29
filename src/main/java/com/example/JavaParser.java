package com.example;

import java.io.IOException;
import java.io.FileInputStream;

import com.github.javaparser.ast.Node;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class JavaParser{

    public static void main(String[] args) throws IOException {
        // Path to the Java source file
        String filePath = "src/main/java/com/example/Shapes.java";

        // Parse the Java source file
        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(filePath));

        // Generate a parse tree
        ParseTreeGenerator parseTreeGenerator = new ParseTreeGenerator();
        parseTreeGenerator.visit(cu, null);
        String parseTree = parseTreeGenerator.getParseTree();

        // Print parse tree
        System.out.println("\nParse Tree:");
        System.out.println(parseTree);

        // Count the number of tokens

        // Count terminals in the parse tree
        int terminalCount = countTerminals(cu);
        System.out.println("\nNumber of Tokens: " + terminalCount);

    }

    // Visitor class to count tokens
    private static int countTerminals(Node node) {
        int count = 0;
        if (node.getChildNodes().isEmpty()) {
            // This is a leaf node, so it represents a terminal
            count++;
        } else {
            // This is an internal node, so count the terminals in its children
            for (Node child : node.getChildNodes()) {
                count += countTerminals(child);
            }
        }
        return count;
    }

    // Visitor class to generate parse tree
    private static class ParseTreeGenerator extends VoidVisitorAdapter<Void> {
        private StringBuilder parseTree = new StringBuilder();

        @Override
        public void visit(CompilationUnit cu, Void arg) {
            printTree(cu, "");
            super.visit(cu, arg);
        }

        public String getParseTree() {
            return parseTree.toString();
        }

        private void printTree(Node node, String indent) {
            parseTree.append(indent);
            parseTree.append(node.getClass().getSimpleName());
            parseTree.append(" : ");
            parseTree.append(node.toString());
            parseTree.append("\n");

            for (Node child : node.getChildNodes()) {
                printTree(child, indent + "  ");
            }
        }
    }

}

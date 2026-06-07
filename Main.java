package org.example;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.util.Set;

public class Main {

    public static void main(String[] args) {


//        try (Context context = Context.newBuilder()
//                .allowAllAccess(true)
//                .build()) {
//
//            Set<String> languages =
//                    context.getEngine().getLanguages().keySet();
//
//            for (String id : languages) {
//
//                System.out.println("Initializing language " + id);
//                context.initialize(id);
//
//                switch (id) {
//                    case "python":
//                        context.eval("python", "print('Hello Python!')");
//                        break;
//
//                    case "js":
//                        context.eval("js", "print('Hello JavaScript!')");
//                        break;
//
//                    case "ruby":
//                        context.eval("ruby", "puts 'Hello Ruby!'");
//                        break;
//
//                    case "java":
//                        Value out = context.getBindings("java")
//                                .getMember("java.lang.System")
//                                .getMember("out");
//                        out.invokeMember("println", "Hello Espresso Java!");
//                        break;
//                }
//            }
//        }

        Context context = Context.newBuilder()
                .allowAllAccess(true)
                .build();
            String python =
                    "from collections import defaultdict\n" +
                            "\n" +
                            "def suma_control(v):\n" +
                            "    return sum(ord(c) for c in v)\n" +
                            "\n" +
                            "v = ['ana', 'naa', 'abc', 'cab', 'test', 'sett', 'bc', 'ad']\n" +
                            "groups = defaultdict(list)\n" +
                            "\n" +
                            "for w in v:\n" +
                            "    groups[suma_control(w)].append(w)\n" +
                            "\n" +
                            "for i, word_list in groups.items():\n" +
                            "    if len(word_list) > 1:\n" +
                            "        print(f'Suma {i}: {word_list}')\n";

            System.out.println("Running Python checksum application...");
            context.eval("python", python);
        }
    }

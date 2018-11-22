package com.infoshareacademy.tailandczycy.console;

public class Menu {

    public String showMenu() {
        String menuString;


        menuString = ""
                + "============================================================\n"
                + "||     Welcome to your personal financial analyzer        ||          {\n"
                + "============================================================       {   }\n"
                + "||   Choose an operation:                                 ||        }_ { __{\n"
                + "||        1. Add an expense                               ||     .'{    }   }'-.\n"
                + "||        2. Modify your expense                          ||    (   }       {   )\n"
                + "||        3. Delete your expense                          ||    |`-.._______..-'|\n"
                + "||        4. Add a category for your expenses             ||    |               ;--.\n"
                + "||        5. Delete a category                            ||    |              (__  \\\n"
                + "||        6. Display expenses per category                ||    |               | )  )\n"
                + "||        7. Display all expenses in a given period       ||    |               |/  /\n"
                + "||        8. Define budget                                ||    |               /  /\n"
                + "||        9. Set up upper limit restriction               ||    |              (  /\n"
                + "============================================================    \\               y'\n"
                + "                                                                 `-.._______..-'\n";

        return menuString;
    }
}


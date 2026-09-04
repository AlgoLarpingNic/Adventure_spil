void main() {
 //AAAAA
    int rækkeMin = 1;
    int rækkeMax = 5;
    int randomRække = (int)(Math.random() * rækkeMax - rækkeMin);


    int sædeMin = 1;
    int sædeMax = 8;
    int randomSæde = (int)(Math.random() * sædeMax - sædeMin);



    boolean[][] biografSal = new boolean[5][8];
    biografSal[randomSæde][randomRække] = true;
    biografSal[2][2] = true;
    biografSal[2][3] = true;
    biografSal[2][4] = true;
    biografSal[2][5] = true;
    biografSal[3][3] = true;
    biografSal[3][4] = true;

    final String BOOKET = "|X|";
    final String LEDIG = "|_|";

    String[]movieProgram = new String[5];
    movieProgram[0] = "Gladiator II";
    movieProgram[1] = "Odessy";
    movieProgram[2] = "Wolf of Wallstreet remastered";
    movieProgram[3] = "Festen";
    movieProgram[4] = "Løvernes Konge II: Simbas stolthed";

    //kinopalæets kundesystem
    boolean systemIsRunning = true;
    while(systemIsRunning) {

        //print menu
        String menu = ("1. Se program\n" + "2. Rediger program\n" + "3. Exit\n");
        IO.println(menu);

        //omdan ref. til primitivt tal for viderevalg og automatisk tæller til menuen
        int menuValg = Integer.parseInt(IO.readln("Tryk på et tal vist i menuen for at fortsætte: "));
        if (menuValg == 1) {
            for (int menuCount = 0; menuCount < movieProgram.length; menuCount++) {
                IO.println((menuCount + 1) + ". film: " + movieProgram[menuCount] + "\n");}

            //5 film fra vores array kan vælges
            int filmValg = Integer.parseInt(IO.readln("Tryk på et tal foran filmens navn, for at vælge film: "));
            if (filmValg == 1 || filmValg == 2 || filmValg == 3 || filmValg == 4 || filmValg == 5);


            //"flere billetter"-funktion
            int flereBilletter = Integer.parseInt(IO.readln("Hvor mange billetter vil du købe? indtast antal her: "));
            int billetCounter = 0;
            boolean billetterTotal = true;
            while (billetterTotal == (billetCounter < flereBilletter && flereBilletter < 40)) {
                billetCounter++;



                //print alle de optaget og ledige pladser før det vælges (og tæller sædetal + rækketal)
                boolean plads = false;
                while (!plads) {
                    int counterFørBooking = 1;
                    IO.println("Vælg venligst et sæde, dem med X betyder at de er optaget");
                    IO.println( "\t----------- (lærred) ---------- \n" +
                            "\t 1 \t 2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t");
                    for (boolean[] række : biografSal){
                        IO.print(counterFørBooking + "\t");
                        for (boolean sæde : række){
                            if
                            (!sæde) {IO.print(LEDIG + "\t");}

                            else
                            {IO.print(BOOKET + "\t");}
                        }
                        IO.println();
                        counterFørBooking++;
                    }

                    //række- og sædevalg er i "-1", da vi starter i nul, så deres valg må ikke kunne overstige array-tal(5,8)
                    int række = Integer.parseInt(IO.readln("Vælg venligst række: "));
                    int sæde = Integer.parseInt(IO.readln("Vælg venligst et sæde på rækken: "));

                    int rækkeValgt = række - 1;
                    int sædeValgt = sæde - 1;

                    //tjekker om vi holder os inden for grænseværdierne
                    boolean erBooked = biografSal[rækkeValgt][sædeValgt];
                    if (erBooked) {
                        IO.println("\nSædet er optaget");
                        if (rækkeValgt <= 0 || rækkeValgt >= 5 || sædeValgt <= 0 || sædeValgt >= 8) {
                            IO.println("Sæde- og/eller række du har prøvet at booke, er ikke gyldigt");
                        }
                    }
                    else {          //hvis at vores biografsal's række + sæde IKKE er true, så sæt indtastet valg til true
                        if (!biografSal[rækkeValgt][sædeValgt]) {
                            biografSal[rækkeValgt][sædeValgt] = true;
                            IO.println("\nDu skal sidde på række: " + (rækkeValgt + 1) + ", sæde: " + (sædeValgt + 1));
                        }
                    }
                    //printer de nyligt optaget pladser for at tjekke om det stemmer
                    int counterEfterBooking = 1;
                    IO.println( "\t----------- (lærred) ---------- \n" +
                            "\t 1 \t 2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t");
                    for (boolean[] rækkePos : biografSal){
                        IO.print((counterEfterBooking) + "\t");
                        for (boolean sædePos : rækkePos){
                            if (!sædePos) {
                                IO.print(LEDIG + "\t");}
                            else {
                                IO.print(BOOKET + "\t");}
                        }
                        IO.println();
                        counterEfterBooking++;

                    }
                    plads = true;}

            }

        }
        String merSalg = IO.readln("Vil du købe flere billetter eller afslutte? indtast ja eller nej: ");
        if (merSalg.equalsIgnoreCase("ja")){
            IO.println("Du stilles nu tilbage til menuen.\n");
        }
        else {
            IO.println("\nnyd filmen :)");
            systemIsRunning = false;
        }


        if (menuValg == 2) {
            for (int indexCount = 0; indexCount < movieProgram.length; indexCount++) {
                IO.println((indexCount + 1) + ". film: " + movieProgram[indexCount]);
            }

            int filmNr = Integer.parseInt(IO.readln("Hvilken film vil du erstatte? "));
            String nyTitel = IO.readln("Indtast den nye titel: ");
            movieProgram[filmNr - 1] = nyTitel;

            IO.println("Opdateret program: ");
            for (int indexCount = 0; indexCount < movieProgram.length; indexCount++) {
                IO.println((indexCount + 1) + ". film: " + movieProgram[indexCount]);
            }
        }

        if (menuValg == 3) {
            IO.println("Ha' en dejlig dag :)");
            systemIsRunning = false;
        }
    }
}
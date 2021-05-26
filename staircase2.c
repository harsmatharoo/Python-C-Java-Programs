#include <stdio.h>
#include <math.h>
int main()
{
    int m, p, n;                 // inputs
    int i, j, k;                // loop iterations
    int b, y, x;               // printing individual stair/staircases
    char space[] = " ";
    int z;
    int rem;

printf("Enter number of: staircases, stairs, rows (with a space in between each): \n");
scanf("%d%d%d", &n, &m, &p);

if ((n<1 || n>100) || (m<1 || m>9) || (p<1 || p>100)){

if (n>100 || n<1){
    printf("n = %d", n);
    printf("  , must be in [1,100]\n");}

if (m>9 || m<9){
    printf("m = %d", m);
    printf("  , must be in [1,9]\n");}

if (p>100 || p<1){
    printf("p = %d", p);
    printf("  , must be in [1,100]\n");}}

else {
    if (n % p == 0){                    //prints out staircases only for values divisible by p
        for (b = 0; b < n/p; b++){
            for (k = 0; k <  m; k++){
                for (j = 0; j < p; j++){
                    
            if (k == 0){
                 for (y = 0; y < m; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 1){
                    x = x + 1;
                    printf("%d", m);}}
                 
            if (k == 1){
                 for (y = 0; y < m - 1; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 2){
                    x = x + 1;
                    printf("%d", m); }}
                    
            if (k == 2){
                 for (y = 0; y < m - 2; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 3){
                    x = x + 1;
                    printf("%d", m); }}

            if (k == 3){
                 for (y = 0; y < m - 3; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 4){
                    x = x + 1;
                    printf("%d", m); } }

            if (k == 4){
                 for (y = 0; y < m - 4; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 5){
                    x = x + 1;
                    printf("%d", m); } }

            if (k == 5){
                 for (y = 0; y < m - 5; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 6){
                    x = x + 1;
                    printf("%d", m); }}
                    
            if (k == 6){
                 for (y = 0; y < m - 6; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 7){
                    x = x + 1;
                    printf("%d", m); }}
                    
            if (k == 7){
                 for (y = 0; y < m - 7; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 8){
                    x = x + 1;
                    printf("%d", m); }}

            if (k == 8){
                for (y = 0; y < m - 8; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 9){
                    x = x + 1;
                    printf("%d", m); }}}

    printf("\n");}

    printf("\n");}}

else if (n % p != 0) {           // Searches for a number <n that is % p == 0 
    for (z = n; z > 0; z--){
        if (z % p == 0){
            break;}}
    rem = n - z;                 // Remaining leftover staircases

        for (b = 0; b < z/p; b++){            // prints out the staircases for integer z
        for (k = 0; k < m; k++){
            for (j = 0; j < p; j++){
            
            if (k == 0){
                for (y = 0; y < m; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 1){
                    x = x + 1;
                    printf("%d", m);}}

                 
            if (k == 1){
                 for (y = 0; y < m - 1; y++){
                     printf("%s", space);}
                x = 0;
                 while (x < 2){
                    x = x + 1;
                    printf("%d", m); }}

                    
            if (k == 2){
                 for (y = 0; y < m - 2; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 3){
                    x = x + 1;
                    printf("%d", m); }}


            if (k == 3){
                 for (y = 0; y < m - 3; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 4){
                    x = x + 1;
                    printf("%d", m); } }


            if (k == 4){
                 for (y = 0; y < m - 4; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 5){
                    x = x + 1;
                    printf("%d", m); } }


            if (k == 5){
                 for (y = 0; y < m - 5; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 6){
                    x = x + 1;
                    printf("%d", m); }}

                    
            if (k == 6){
                 for (y = 0; y < m - 6; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 7){
                    x = x + 1;
                    printf("%d", m); }}

                    
            if (k == 7){
                 for (y = 0; y < m - 7; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 8){
                    x = x + 1;
                    printf("%d", m); }}


            if (k == 8){
                for (y = 0; y < m - 8; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 9){
                    x = x + 1;
                    printf("%d", m); } }

        }
    printf("\n");
    }
    printf("\n");
    }
    }    

for (b = 0; b < 1; b++){                       // prints out the remaining staircases = rem
        for (k = 0; k < m; k++){
            for (j = 0; j < rem; j++){

             if (k == 0){
                 for (y = 0; y < m; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 1){
                    x = x + 1;
                    printf("%d", m);}}
                 
            if (k == 1){
                 for (y = 0; y < m - 1; y++){
                     printf("%s", space);}
                x = 0;
                 while (x < 2){
                    x = x + 1;
                    printf("%d", m); }}
                    
            if (k == 2){
                 for (y = 0; y < m - 2; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 3){
                    x = x + 1;
                    printf("%d", m); }}

            if (k == 3){
                 for (y = 0; y < m - 3; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 4){
                    x = x + 1;
                    printf("%d", m); } }

            if (k == 4){
                 for (y = 0; y < m - 4; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 5){
                    x = x + 1;
                    printf("%d", m); } }

            if (k == 5){
                 for (y = 0; y < m - 5; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 6){
                    x = x + 1;
                    printf("%d", m); }}
                    
            if (k == 6){
                 for (y = 0; y < m - 6; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 7){
                    x = x + 1;
                    printf("%d", m); }}
                    
            if (k == 7){
                 for (y = 0; y < m - 7; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 8){
                    x = x + 1;
                    printf("%d", m); }}

            if (k == 8){
                for (y = 0; y < m - 8; y++){
                     printf("%s", space);}
                x = 0;
                while (x < 9){
                    x = x + 1;
                    printf("%d", m); } }

        }
    printf("\n");}}}
    
    return 0;
}


#include <iostream>
#include "fstream"
#include "math.h"

using namespace std;

void write_in_file(double* x, double* func, int dots){
    char filename[1024];
    cout << "\nEnter path to file in which write data: ";
    cin.ignore();
    cin.getline(filename, 1024);
    ofstream fout(filename);
    if (!fout){
        do{
            cout << "Path to file is wrong. Try again: ";
            cin.ignore();
            cin.getline(filename, 1024);
        }while(!fout);
        ofstream fout(filename);
    }

    for (int i = 0; i < dots; i++){
        fout << x[i] << " ; " << func[i] << endl;
    }
}

double function(double x){
    double func;
        if ( x < 6 and x > 5 ) {
            func = pow((1/8), (1/2)) + pow(cos(pow(x, (2 * x))), (1/5)) * (1/(abs(sin(pow(x, 5)) + 6.3)));
        }
        else if ( x <= 5 and x >= -5 ) {
            if (x != 0) {
                func = pow(x, -23) + 4;
            }
            if (x == 0){
                func = pow(9, 100);
            }
        }
        else {
            func = pow(x, -20);
        }
    return func;
}

int main() {
    int dots;
    double a, b;
    cout << "Enter [a;b]:\n\ta = ";
    cin >> a;
    cout << "\tb = ";
    cin >> b;
    cout << "Enter count of dots: ";
    do {
        cin >> dots;
        if (!(dots > 0)){
            cout << "Count of dots can't be negative or zero! Try again: ";
        }
    }while(!(dots > 0));
    double x = a;
    double array_of_x[dots], array_of_func[dots];
    for (int i = 0; i < dots; i++){
        double func = function(x);
        array_of_x[i] = x;
        array_of_func[i] = func;
        x += (b - a) / (double) dots;
    }
    cout << "Calculation of dots completed";
    write_in_file(array_of_x, array_of_func, dots);
    cout << "All data was recorded correctly";
    return 0;
}

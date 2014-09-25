#include "MyVector.h"

using namespace std;

int main()
{
    int n;
    cout << "n = ";
    cin >> n;

    MyVector *mas = new MyVector[n];

    for(int i = 0; i < n; i++)
    {
       mas[i] = MyVector(i+2);
    }

    delete []mas;
    mas = nullptr;

    return 0;
}

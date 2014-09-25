#include <iostream>

#ifndef __MyVector_H_
#define __MyVector_H_

using namespace std;
class MyVector
{
public:

    MyVector();
    MyVector(int n);
    MyVector(int n, double *coord);
    MyVector(const MyVector&original);

    ~MyVector();

    double Module()const;
    double ScalarMultiply(const MyVector & other)const;
    MyVector Addition(const MyVector & other)const;
    MyVector Substracion(const MyVector & other)const;
    MyVector Multiply(double scalar)const;

    MyVector & operator=(const MyVector & other);

    MyVector operator+(const MyVector & other) const;
    MyVector operator-(const MyVector & other) const;
    MyVector operator*(double scalar) const;
    double operator*(const MyVector & other) const;
    double & operator[](int i) const;

    MyVector& operator++();
    MyVector operator++(int);

    MyVector& operator--();
    MyVector operator--(int);

    friend ostream & operator<<(ostream & mystream, const MyVector &other);
    friend istream & operator>>(istream & mystream, MyVector &other);

    static bool IsCollinear(const MyVector & firstVector, const MyVector & secondVector);
    static bool IsOrthogonal(const MyVector & firstVector, const MyVector & secondVector);

private:
    int n;
    double* coord;
};


#endif //__MyVector_H_

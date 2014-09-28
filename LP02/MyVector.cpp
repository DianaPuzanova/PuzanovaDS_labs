#include <math.h>
#include "MyVector.h"
 
using namespace std; 

MyVector::MyVector(): n(0), coord(nullptr)
{

}

MyVector::MyVector(int n): n(n), coord(nullptr)//TODO ,coord(nullptr)
{
    coord = new double[n];

    for (int i = 0; i < n; i++)
    {
        coord[i] = 0;
    }
}

MyVector::MyVector(int n, double *coord)//TODO а вось гэта бомба замаруджанага дзеяння
{
    this->n = n;
    this->coord = new double[n];

    for(int i = 0; i < n; i++)
    {
        this->coord[i] = coord[i];
    }
}

MyVector::MyVector(const MyVector &original): coord(nullptr)//TODO :coord(nullptr)
{
    n = original.n;
    coord = new double[n];

    for (int i = 0; i < n; i++)
    {
        coord[i] = original[i];
    }
}

MyVector::~MyVector()
{
    delete [] coord;
    coord = nullptr;
    n = 0;
}


double &MyVector::operator[](int i) const
{
    return coord[i];
}


double MyVector::ScalarMultiply(const MyVector &other)const
{
    double result = 0;

    for (int i = 0; i < n; i++)
    {
        result += coord[i] * other[i];
    }

    return result;
}

double MyVector::Module()const// а чаму б не вызвалі ScalarMultiply
{
     return sqrt(ScalarMultiply(*this));
}

MyVector MyVector::Addition(const MyVector &other)const
{
    MyVector result(n);

    for (int i = 0; i < n; i++)
    {
        result[i] = coord[i] + other[i];
    }

    return result;
}

MyVector MyVector::Substracion(const MyVector &other)const
{
    MyVector result(n);

    for (int i = 0; i < n; i++)
    {
        result[i] = coord[i] - other[i];
    }

    return result;
}

MyVector MyVector::Multiply(double scalar)const
{
    MyVector result(n);

    for (int i = 0; i < n; i++)
    {
        result[i] = coord[i] * scalar;
    }

    return result;
}

MyVector &MyVector::operator=(const MyVector &other)
{
    if(this != &other)
    {
        delete [] coord;

        n = other.n;
        coord = new double[n];

        for (int i = 0; i < n; i++)
        {
            coord[i] = other[i];
        }
    }

    return *this;
}

MyVector MyVector::operator+(const MyVector &other) const
{
    return Addition(other);
}

MyVector MyVector::operator-(const MyVector &other) const
{
    return Substracion(other);
}

MyVector MyVector::operator*(double scalar) const
{
    return Multiply(scalar);
}

double MyVector::operator*(const MyVector &other) const
{
    return ScalarMultiply(other);
}


MyVector& MyVector::operator++()
{
    for (int i = 0; i < n; i++)
    {
        coord[i]++;
    }

    return *this;
}

MyVector MyVector::operator++(int)
{
    MyVector temp = *this;
    ++*this;
    return temp;
}

MyVector& MyVector::operator--()
{
    for (int i = 0; i < n; i++)
    {
        coord[i]--;
    }

    return *this;
}

MyVector MyVector::operator--(int)
{
    MyVector temp = *this;
    --*this;
    return temp;
}

ostream & operator<<(ostream & mystream, const MyVector &other)
{
    if (other.n)
    {

        mystream << "(" << other[0];

        for (int i = 1; i < other.n; i++)
        {
            mystream << "," << other[i];
        }

        mystream << ")";
    }
    return mystream;
}

istream & operator>>(istream & mystream, MyVector &other)
{
    cout << "Enter " << other.n << " coordinates" << endl;

    for (int i = 0; i < other.n; i++)
    {
        mystream >> other[i];
    }

    return mystream;
}

bool MyVector::IsCollinear(const MyVector &firstVector, const MyVector &secondVector)
{
    double result = (firstVector * secondVector)/(firstVector.Module() * secondVector.Module());
    return result == 1 || result == -1;
}

bool MyVector::IsOrthogonal(const MyVector &firstVector, const MyVector &secondVector)
{
    return (firstVector * secondVector) == 0;
}

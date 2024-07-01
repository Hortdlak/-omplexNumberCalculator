public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        if (Double.isNaN(real) || Double.isNaN(imag)) {
            throw new IllegalArgumentException("Действительная и мнимая части не могут быть NaN");
        } //вряд-ли нужны так как уже принимаем double
        else if (Double.isInfinite(real) || Double.isInfinite(imag)) {
            throw new IllegalArgumentException("Действительная и мнимая части не могут быть бесконечными");
        } //вряд-ли нужны так как уже принимаем double
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imag * other.imag;
        double newImag = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denom = other.real * other.real + other.imag * other.imag;
        if (denom == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        //как же хочется использовать "multiply" для рефакторинга 
        double newReal = (this.real * other.real + this.imag * other.imag) / denom;
        double newImag = (this.imag * other.real - this.real * other.imag) / denom;
        return new ComplexNumber(newReal, newImag);
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }
}
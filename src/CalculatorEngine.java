import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {

    Calculator parent;
    //ссылка на окно калькулятора
    char selectedAction = ' ';
    double currentResult = 0;
    // +, -, /, или *
    // Конструктор сохраняет ссылку на окно калькулятора
    // в переменной экземпляра класса
    CalculatorEngine(Calculator parent){
        this.parent = parent;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Получаем источник события
        JButton clickedButton = (JButton)e.getSource();
        // Получаем надпись на кнопке
        String dispFieldText = parent.displayField.getText();

        double displayValue = 0;
        // Получить число из дисплея калькулятора,
        // если он не пустой.

        if (!"".equals(dispFieldText)) {
            displayValue = Double.parseDouble(dispFieldText);
        }
        Object src = e.getSource();

//        Для каждой кнопки арифметического действия
//        запомнить его: +, -, /, или *, сохранить текущее число
//        в переменной currentResult, и очистить дисплей
//        для ввода нового числа


        if (src == parent.buttonPlus){
            selectedAction = '+';
            currentResult=displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMinus){
            selectedAction = '-';
            currentResult=displayValue;
            parent.displayField.setText("");
        }else if (src == parent.buttonDiv){
            selectedAction = '/';
            currentResult=displayValue;
            parent.displayField.setText("");
        } else if (src == parent.buttonMulti){
            selectedAction = '*';
            currentResult=displayValue;
            parent.displayField.setText("");}
        else if (src == parent.buttonEqual) {
            // Совершить арифметическое действие, в зависимости
            // от selectedAction, обновить переменную currentResult
            // и показать результат на дисплее
            if (selectedAction == '+') {
                currentResult += displayValue;
                // Сконвертировать результат в строку, добавляя его
                // к пустой строке и показать его
                parent.displayField.setText("" + currentResult);
            }
            else if (selectedAction=='-'){
                currentResult -=displayValue;
                parent.displayField.setText(""+currentResult);
            }else if (selectedAction=='/'){
                currentResult /=displayValue;
                parent.displayField.setText(""+currentResult);
            }else if (selectedAction=='*'){
                currentResult*=displayValue;
                parent.displayField.setText(""+currentResult);
            }
        }
        else{
// Для всех цифровых кнопок присоединить надпись на
// кнопке к надписи в дисплее
            String clickedButtonLabel= clickedButton.getText();
            parent.displayField.setText(dispFieldText +
                    clickedButtonLabel);
        }


    }
}

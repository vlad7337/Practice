package org.example.practice;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PracticeController {
    private Stage stage;
    static String func1, func2, func3;
    static List<Double> dataFunc;
    @FXML
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    // rb1 - "y=sin(x)"; rb2 - "y=f(x)"; rb3 - "y=random"; rb4 - "x"(compress);rb5 - "y"(compress);rb6 - "x"(stretch);rb7 - "y"(stretch);
    @FXML
    private TextField textFieldX, textFieldY;
    @FXML
    private TabPane tabPane;
    @FXML
    private LineChart lineChart;

    protected List<Double> getPointsInRange(double a, double b, int n, int func){
        List<Double> points = new ArrayList<>();

        double dx = (b - a) / n, y = 0;
        for (int i = 0; i < n; i++){
            double x = a + dx * i;
            if(rb4.isSelected()){
                if (rb5.isSelected()){
                    if (rb6.isSelected()){
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x);
                                func1 = "y=sin(x)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3);
                                func3 = "y=x³";
                            }
                        }
                        else{
                            if(func == 1){
                                y = Math.sin(x) / 2;
                                func1 = "y=sin(x)/2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) / 2;
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)/2";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3) / 2;
                                func3 = "y=(x³)/2";
                            }
                        }
                    }
                    else{
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x * 2);
                                func1 = "y=sin(x*2)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2) / 2;
                                func2 = "y=f(x*2)";
                            }
                            if (func == 3){
                                y = Math.pow((x * 2), 3);
                                func3 = "y=(x*2)³";
                            }
                        }
                        else{
                            if (func == 1){
                                y = Math.sin(x * 2) / 2;
                                func1 = "y=sin(x*2)/2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) / 2;
                                x = dataFunc.get(i * 2) / 2;
                                func2 = "y=f(x*2)/2";
                            }
                            if (func == 3){
                                y = Math.pow((x * 2), 3) / 2;
                                func3 = "y=((x*2)³)/2";
                            }
                        }
                    }
                }
                else{
                    if (rb6.isSelected()){
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x) * 2;
                                func1 = "y=sin(x)*2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) * 2;
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)*2";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3) * 2;
                                func3 = "y=(x³)*2";
                            }
                        }
                        else{
                            if (func == 1){
                                y = Math.sin(x);
                                func1 = "y=sin(x)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3);
                                func3 = "y=x³";
                            }
                        }
                    }
                    else{
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x * 2) * 2;
                                func1 = "y=sin(x*2)*2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) * 2;
                                x = dataFunc.get(i * 2) / 2;
                                func2 = "y=f(x*2)*2";
                            }
                            if (func == 3){
                                y = Math.pow((x * 2), 3) * 2;
                                func3 = "y=((x*2)³)*2";
                            }
                        }
                        else{
                            if (func == 1){
                                y = Math.sin(x * 2);
                                func1 = "y=sin(x*2)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2) / 2;
                                func2 = "y=f(x*2)";
                            }
                            if (func == 3){
                                y = Math.pow((x * 2), 3);
                                func3 = "y=(x*2)³";
                            }
                        }
                    }
                }
            }
            else{
                if (rb5.isSelected()){
                    if (rb6.isSelected()){
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x / 2);
                                func1 = "y=sin(x/2)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2) * 2;
                                func2 = "y=f(x/2)";
                            }
                            if (func == 3){
                                y = Math.pow((x / 2), 3);
                                func3 = "y=(x/2)³";
                            }
                        }
                        else{
                            if (func == 1){
                                y = Math.sin(x / 2) / 2;
                                func1 = "y=sin(x/2)/2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) / 2;
                                x = dataFunc.get(i * 2) * 2;
                                func2 = "y=f(x/2)/2";
                            }
                            if (func == 3){
                                y = Math.pow((x / 2), 3) / 2;
                                func3 = "y=((x/2)³)/2";
                            }
                        }
                    }
                    else{
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x);
                                func1 = "y=sin(x)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3);
                                func3 = "y=x³";
                            }
                        }
                        else{
                            if (func == 1){
                                y = Math.sin(x) / 2;
                                func1 = "y=sin(x)/2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) / 2;
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)/2";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3) / 2;
                                func3 = "y=(x³)/2";
                            }
                        }
                    }
                }
                else{
                    if (rb6.isSelected()){
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x / 2) * 2;
                                func1 = "y=sin(x/2)*2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) * 2;
                                x = dataFunc.get(i * 2) * 2;
                                func2 = "y=f(x/2)*2";
                            }
                            if (func == 3){
                                y = Math.pow((x / 2), 3) * 2;
                                func3 = "y=((x/2)³)*2";
                            }
                        }
                        else{
                            if (func == 1){
                                y = Math.sin(x / 2);
                                func1 = "y=sin(x/2)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2) * 2;
                                func2 = "y=f(x/2)";
                            }
                            if (func == 3){
                                y = Math.pow((x / 2), 3);
                                func3 = "y=(x/2)³";
                            }
                        }
                    }
                    else{
                        if (rb7.isSelected()){
                            if (func == 1){
                                y = Math.sin(x) * 2;
                                func1 = "y=sin(x)*2";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2) * 2;
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)*2";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3) * 2;
                                func3 = "y=(x³)*2";
                            }
                        }
                        else {
                            if (func == 1){
                                y = Math.sin(x);
                                func1 = "y=sin(x)";
                            }
                            if (func == 2){
                                y = dataFunc.get(1 + i * 2);
                                x = dataFunc.get(i * 2);
                                func2 = "y=f(x)";
                            }
                            if (func == 3){
                                y = Math.pow(x, 3);
                                func3 = "y=x³";
                            }
                        }
                    }
                }
            }
            if (!textFieldX.getText().isEmpty()){
                x += Double.parseDouble(textFieldX.getText());
            }
            if (!textFieldY.getText().isEmpty()){
                y += Double.parseDouble(textFieldY.getText());
            }
            points.add(x);
            points.add(y);
        }

        return points;
    }

    private void centerAxisLabels(NumberAxis axis) {
        axis.setTickLabelGap(0);
        axis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.format("%.2f", object.doubleValue());
            }

            @Override
            public Number fromString(String string) {
                return Double.parseDouble(string);
            }
        });

        axis.setTickLabelRotation(0);
    }

    @FXML
    protected void onChooseFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                dataFunc = readFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private List<Double> readFile(File file) throws IOException {
        List<Double> dataList = new ArrayList<>();
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] parts = line.split(";");
            for (String part : parts) {
                String trimmedPart = part.trim();
                double value;
                if (trimmedPart.equalsIgnoreCase("inf")) {
                    value = Double.POSITIVE_INFINITY;
                } else if (trimmedPart.equalsIgnoreCase("-inf")) {
                    value = Double.NEGATIVE_INFINITY;
                } else {
                    value = Double.parseDouble(trimmedPart);
                }
                dataList.add(value);
            }
        }
        return dataList;
    }

    @FXML
    protected void onClearButtonClick(){
        lineChart.getData().clear();
    }

    @FXML
    protected void onBuildButtonClick(){
        tabPane.getSelectionModel().select(1);

        List<Double> pointsRangeFunc1 = getPointsInRange(-100, 100, 1000, 1);
        List<Double> pointsRangeFunc2;
        List<Double> pointsRangeFunc3 = getPointsInRange(-100, 100, 1000, 3);


        XYChart.Series seriesFunc1 = new XYChart.Series();
        XYChart.Series seriesFunc2 = new XYChart.Series();
        XYChart.Series seriesFunc3 = new XYChart.Series();

        if (rb1.isSelected()) {
            for (int i = 0; i < 2000; i += 2) {
                seriesFunc1.getData().add(new XYChart.Data(pointsRangeFunc1.get(i), pointsRangeFunc1.get(i + 1)));
            }
            seriesFunc1.setName(func1);
            lineChart.getData().add(seriesFunc1);
        }

        if (rb2.isSelected()) {
            if (dataFunc == null) {
                onChooseFileButtonClick();
            }
            pointsRangeFunc2 = getPointsInRange(-100, 100, dataFunc.size() / 2, 2);
            for (int i = 0; i < dataFunc.size() / 2; i++) {

                if (pointsRangeFunc2.get(i * 2) != Double.NEGATIVE_INFINITY && pointsRangeFunc2.get(i * 2 + 1) != Double.NEGATIVE_INFINITY) {
                    seriesFunc2.getData().add(new XYChart.Data(pointsRangeFunc2.get(i * 2), pointsRangeFunc2.get(1 + i * 2)));
                }
            }
            seriesFunc2.setName(func2);
            lineChart.getData().add(seriesFunc2);
        }
        if (rb3.isSelected()) {
            for (int i = 0; i < 2000; i += 2) {
                System.out.println(pointsRangeFunc3.get(i) + "," + pointsRangeFunc3.get(i + 1));
                seriesFunc3.getData().add(new XYChart.Data(pointsRangeFunc3.get(i), pointsRangeFunc3.get(i + 1)));
            }
            seriesFunc3.setName(func3);
            lineChart.getData().add(seriesFunc3);
        }

        centerAxisLabels((NumberAxis) lineChart.getYAxis());
        centerAxisLabels((NumberAxis) lineChart.getXAxis());

    }

}
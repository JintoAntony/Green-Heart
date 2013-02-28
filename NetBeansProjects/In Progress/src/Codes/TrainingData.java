/**
 * Copyright 2010 Neuroph Project http://neuroph.sourceforge.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package Codes;


import java.util.Arrays;


import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.core.learning.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.LMS;
/**
 * Creates training set from the given data.
 * See http://neuroph.sourceforge.net/tutorials/StockMarketPredictionTutorial.html
 * @author Dr.V.Steinhauer
 */
public class TrainingData {

    private String[] valuesRow;
    private DataSet trainingSet = new DataSet(4, 1);
    private double normalizer = 10000.0D;
    private double minlevel = 0.0D;

 /*   public TrainingData() {
    }

    public TrainingData(String[] valuesRow) {
        this.setValuesRow(valuesRow);
    }


    public String[] getValuesRow() {
        return valuesRow;
    }

    public void setValuesRow(String[] valuesRow) {
        this.valuesRow = valuesRow;
    }

    public double getNormalizer() {
        return normalizer;
    }

    public void setNormalizer(double normolizer) {
        this.normalizer = normolizer;
    }

   */ public void assign(String readdata){
        valuesRow = readdata.split(",");
        getTrainingSet();
    }


    public DataSet getTrainingSet() {
        int maxIterations = 10000;
        NeuralNetwork neuralNet = new MultiLayerPerceptron(4, 9, 1);
        ((LMS) neuralNet.getLearningRule()).setMaxError(0.001);//0-1
        ((LMS) neuralNet.getLearningRule()).setLearningRate(0.7);//0-1
        ((LMS) neuralNet.getLearningRule()).setMaxIterations(maxIterations);//0-1
        int length = valuesRow.length;
        if (length < 5) {
            System.out.println("valuesRow.length < 5");
            return null;
        }
        try {
            /*for (int i = 0; i < length; i++) {
                String[] s1 = valuesRow[i].split(",");
                String[] s2 = valuesRow[i + 1].split(",");
                String[] s3 = valuesRow[i + 2].split(",");
                String[] s4 = valuesRow[i + 3].split(",");
                String[] s5 = valuesRow[i + 4].split(",");*/
                double d1 = Double.parseDouble(valuesRow[0]) - minlevel / normalizer;
                double d2 = Double.parseDouble(valuesRow[1]) - minlevel / normalizer;
                double d3 = Double.parseDouble(valuesRow[2]) - minlevel / normalizer;
                double d4 = Double.parseDouble(valuesRow[3]) - minlevel / normalizer;
                double d5 = Double.parseDouble(valuesRow[4]) - minlevel / normalizer;
                System.out.println("Input:[" + d1 + "," + d2 + "," + d3 + "," + d4 + "]Output:[" + d5+"]");
                trainingSet.addRow(new DataSetRow(new double[]{d1, d2, d3, d4}, new double[]{d5}));

                DataSet testSet = new DataSet(4, 1);
        testSet.addRow(new DataSetRow(new double[]{d1 / normalizer, d2 / normalizer, d3/ normalizer, d4 / normalizer}, new double[]{d5 / normalizer}));
        String output = null;
        for (DataSetRow testDataRow : testSet.getRows()) {
            neuralNet.setInput(testDataRow.getInput());
            neuralNet.calculate();
            double[] networkOutput = neuralNet.getOutput();
            System.out.print("Input: " + Arrays.toString(testDataRow.getInput()) );
            output = Arrays.toString(networkOutput);
            System.out.println(" Output: "+output);

        }
            //}
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return trainingSet;
    }

    public void setTrainingSet(DataSet trainingSet) {
        this.trainingSet = trainingSet;
    }


}

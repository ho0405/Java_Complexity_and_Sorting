package application;

import shape.*;
import utility.BaseAreaComparator;
import utility.Sorts;
import utility.VolumeComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortManager {
    private String fileName;
    private char compareType;
    private char sortType;
    private Shape[] shapes;
    private long sortTimeInMillis = 0;


    public SortManager(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Expected arguments: -f<filename> -t<h/a/v> -s<b/s/i/m/q/c>");
        }

        for (String arg : args) {
            if (arg.toLowerCase().startsWith("-f")) {
                fileName = arg.substring(2);
            } else if (arg.toLowerCase().startsWith("-t")) {
                compareType = arg.substring(2).charAt(0);
            } else if (arg.toLowerCase().startsWith("-s")) {
                sortType = arg.substring(2).charAt(0);
            }
        }

        if (fileName == null || compareType == '\0' || sortType == '\0') {
            throw new IllegalArgumentException("All arguments (-f, -t, -s) must be provided.");
        }
        fillShapesArray();
        long start = System.currentTimeMillis();
        sortShapes();
        long end = System.currentTimeMillis();
        sortTimeInMillis = end - start;
        printSortedShapes();
        printSortTime();
        
    }


    private void fillShapesArray() {
        

        try (BufferedReader reader = new BufferedReader(new FileReader("res/" + fileName))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int i = 0;
                int numOfShapes = Integer.parseInt(parts[i++].trim());
                shapes = new Shape[numOfShapes];
                System.out.println(shapes.length);
                int count = 0;
                while ( count < numOfShapes ) {
                   
                   String shapeType = parts[i++];
                   //System.out.println(i);
                   switch(shapeType) {
                        // Adjusted the shapeType cases to match the provided values
                        case "Cone":
                            shapes[count]=(new Cone(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                            break;
                        case "SquarePrism":
                           shapes[count]=(new SquareBasePrism(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                            break;
                        case "TriangularPrism":
                           shapes[count]=(new EquilateralTriangleBasePrism(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                            break;
                        case "OctagonalPrism":
                           shapes[count]=(new OctagonalBasePrism(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                            break;
                        case "PentagonalPrism":
                           shapes[count]=(new PentagonBasePrism(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                            break;
                        case "Pyramid":
                           shapes[count]=(new Pyramid(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                           break;
                        case "Cylinder":
                           shapes[count]=(new Cylinder(Double.parseDouble(parts[i++]), Double.parseDouble(parts[i++])));
                           break;
                        default:
                            System.out.println("wrong shapes");
                    }
                   System.out.println(shapes[count]);
                   //System.out.println(count);
                   count++;
                   
                }
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void sortShapes() {
        switch (sortType) {
            case 'B':
            case 'b':
                switch (compareType) {
                    case 'H':
                    case 'h':
                        Sorts.bubbleSort(shapes);
                        break;
                    case 'A':
                    case 'a':
                        Sorts.bubbleSort(shapes, new BaseAreaComparator());
                        break;
                    case 'V':
                    case 'v':
                        Sorts.bubbleSort(shapes, new VolumeComparator());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown compare type: " + compareType);
                }
                break;
            case 'S':
            case 's':
                switch (compareType) {
                    case 'H':
                    case 'h':
                        Sorts.selectionSort(shapes);
                        break;
                    case 'A':
                    case 'a':
                        Sorts.selectionSort(shapes, new BaseAreaComparator());
                        break;
                    case 'V':
                    case 'v':
                        Sorts.selectionSort(shapes, new VolumeComparator());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown compare type: " + compareType);
                }
                break;
            case 'I':
            case 'i':
                switch (compareType) {
                    case 'H':
                    case 'h':
                        Sorts.insertionSort(shapes);
                        break;
                    case 'A':
                    case 'a':
                        Sorts.insertionSort(shapes, new BaseAreaComparator());
                        break;
                    case 'V':
                    case 'v':
                        Sorts.insertionSort(shapes, new VolumeComparator());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown compare type: " + compareType);
                }
                break;
            case 'M':
            case 'm':
                // Merge Sort with different comparators
                switch (compareType) {
                    case 'H':
                    case 'h':
                        Sorts.mergeSort(shapes); // Natural order (Height)
                        break;
                    case 'A':
                    case 'a':
                        Sorts.mergeSort(shapes, new BaseAreaComparator());
                        break;
                    case 'V':
                    case 'v':
                        Sorts.mergeSort(shapes, new VolumeComparator());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown compare type: " + compareType);
                }
                break;
            case 'Q':
            case 'q':
                // Quick Sort with different comparators
                switch (compareType) {
                    case 'H':
                    case 'h':
                        Sorts.quickSort(shapes); // Natural order (Height)
                        break;
                    case 'A':
                    case 'a':
                        Sorts.quickSort(shapes, new BaseAreaComparator());
                        break;
                    case 'V':
                    case 'v':
                        Sorts.quickSort(shapes, new VolumeComparator());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown compare type: " + compareType);
                }
                break;
            case 'C':
            case 'c':
                // Comb Sort with different comparators
                switch (compareType) {
                    case 'H':
                    case 'h':
                        Sorts.combSort(shapes); // Natural order (Height)
                        break;
                    case 'A':
                    case 'a':
                        Sorts.combSort(shapes, new BaseAreaComparator());
                        break;
                    case 'V':
                    case 'v':
                        Sorts.combSort(shapes, new VolumeComparator());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown compare type: " + compareType);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown sort type: " + sortType);
        }
    }

    private void printSortedShapes() { //detailed information about each shape in a more readable format.
        for (int i = 0; i < shapes.length; i += 1000) {  //To change the output to display each shape individually, modify the method to i++.

            StringBuilder shapeInfo = new StringBuilder();

            
            shapeInfo.append(shapes[i].getClass().getSimpleName()).append(": ");

            switch (compareType) {
                case 'h':
                case 'H':
                    shapeInfo.append("Height: ").append(shapes[i].getHeight());
                    break;
                case 'v':
                case 'V':
                    shapeInfo.append("Volume: ").append(shapes[i].getVolume());
                    break;
                case 'a':
                case 'A':
                    shapeInfo.append("Base Area: ").append(shapes[i].getBaseArea());
                    break;
                default:
                    shapeInfo.append("Invalid compare type");
                    break;
            }

            System.out.println(shapeInfo);
        }
    }
    private void printSortTime() {
        System.out.println("Time taken to sort: " + sortTimeInMillis + " ms.");
    }

 
}

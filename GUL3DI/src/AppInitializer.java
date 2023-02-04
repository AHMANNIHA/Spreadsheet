import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.print.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppInitializer extends Application
{
  final static String countryA = "A";
  final static String countryB = "B";
  final static String countryC = "C";
  final static String countryD = "D";
  private TableView<Column> table = new TableView<Column>();
  private final ObservableList<Column> data = FXCollections.observableArrayList(
      new Column("Preselected","Market Attractiveness", "Market Size  in bil $ (medical goods)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Market Growth  in % (medical goods) GAGR 2021-2026", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Legal and regulatory barriers (High, Medium, Low)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Competitive situation (High, Medium, Low)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "GDP per capita ($)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "GDP Growth in %", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Disposable Income per capita", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Inflation Rate in %", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Political stability", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Human Development Index", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Health expenditure and financing (GDP per capita)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Geriatric Population in mil", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Total Population in mil", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Population Growth Rate in %", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Severe Difficulties in Personal Care in % (65 and over)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Self Perceived Severe Difficulties in Personal Care in % (18 and more)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Nursing Personnel per 10000", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Market Attractiveness", "Cultural difference", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Current market share in % (medical goods)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Product fit to customers' demand - Good, Medium, Bad", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Product fit to customers' behaviour - Good, Medium, Bad", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Product differentiation - Good, Medium, Bad", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Threat of Substitution - High, Medium, Low", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Innovation - Excellent, Good, Moderate", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Current distribution channel network (Large, Medium, Small)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
      new Column("Preselected","Competitive Strength", "Export Costs (High, Medium, Low)", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
  );

  protected void Header(Observable s) {
    table.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
      if (e.isPrimaryButtonDown() &&  e.getClickCount() > 1) {
        EventTarget target = e.getTarget();
        TableColumnBase<?, ?> column = null;
        while (target instanceof Node) {
          target = ((Node) target).getParent();
          if (target instanceof TableColumnHeader) {
            column = ((TableColumnHeader) target).getTableColumn();
            if (column != null) break;
          }
        }
        if (column != null) {
          TableColumnBase<?,?> tableColumn = column;
          TextField textField = new TextField(column.getText());
          textField.setMaxWidth(column.getWidth());
          textField.setOnAction(a -> {
            tableColumn.setText(textField.getText());
            tableColumn.setGraphic(null);
          });
          textField.focusedProperty().addListener((src, ov, nv) -> {
            if (!nv) tableColumn.setGraphic(null);
          });
          column.setGraphic(textField);
          textField.requestFocus();
        }
        e.consume();
      }
    });
  }

  final HBox hb = new HBox();

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override public void start(Stage stage)
  {
    Scene scene = new Scene(new Group());
    stage.setTitle("IMS Process");
    stage.centerOnScreen();
    stage.setWidth(1390);
    stage.setHeight(550);

    table.setMaxWidth(1350);
    table.skinProperty().addListener(this::Header);

    final Label label = new Label("MACS Table");
    label.setFont(new Font("Bauhaus 93", 28));

    final Label label1 = new Label("Market Attractiveness 50% / Competitive Strength 50%");
    label1.setFont(new Font("System Bold", 20));

    final Label label2 = new Label("User guide about how the app works with precise instructions");
    label2.setFont(new Font("Arial", 15));
    label2.setVisible(true);


    table.setEditable(true);
    Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>()
    {
      public TableCell call(TableColumn p)
      {
        return new Cell();
      }
    };

    TableColumn column = new TableColumn<>("");
    column.setMaxWidth(0);
    column.setCellValueFactory(
        new PropertyValueFactory<Column,String>("number"));


    TableColumn column0 = new TableColumn("");
    column0.setCellValueFactory(
        new PropertyValueFactory<Column, String>("partName"));

    TableColumn column1 = new TableColumn("Criteria");
    column1.setCellValueFactory(
        new PropertyValueFactory<Column, String>("criteriaName"));
    column1.setCellFactory(TextFieldTableCell.forTableColumn());
    column1.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCriteriaName(
            t.getNewValue());
      }
    });
    column1.setCellFactory(cellFactory);
    column1.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCriteriaName(
            t.getNewValue());
      }
    });

    TableColumn column2 = new TableColumn("Source");
    column2.setCellValueFactory(
        new PropertyValueFactory<Column, String>("sourceName"));
    column2.setCellFactory(TextFieldTableCell.forTableColumn());
    column2.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSourceName(t.getNewValue());
      }
    });
    column2.setCellFactory(cellFactory);
    column2.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSourceName(t.getNewValue());
      }
    });

    TableColumn column3 = new TableColumn("Weight in %");
    column3.setCellValueFactory(
        new PropertyValueFactory<Column, String>("weightAmount"));
    column3.setCellFactory(TextFieldTableCell.forTableColumn());
    column3.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWeightAmount(
            (t.getNewValue()));
      }
    });
    column3.setCellFactory(cellFactory);
    column3.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWeightAmount(
            (t.getNewValue()));
      }
    });

    TableColumn column4 = new TableColumn("Fact");
    column4.setCellValueFactory(
        new PropertyValueFactory<Column, String>("factName1"));
    column4.setCellFactory(TextFieldTableCell.forTableColumn());
    column4.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName1(t.getNewValue());
      }
    });
    column4.setCellFactory(cellFactory);
    column4.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName1(t.getNewValue());
      }
    });
    TableColumn column5 = new TableColumn("Fact");
    column5.setCellValueFactory(
        new PropertyValueFactory<Column, String>("factName2"));
    column5.setCellFactory(TextFieldTableCell.forTableColumn());
    column5.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName2(t.getNewValue());
      }
    });
    column5.setCellFactory(cellFactory);
    column5.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName2(t.getNewValue());
      }
    });
    TableColumn column6 = new TableColumn("Fact");
    column6.setCellValueFactory(
        new PropertyValueFactory<Column, String>("factName3"));
    column6.setCellFactory(TextFieldTableCell.forTableColumn());
    column6.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName3(t.getNewValue());
      }
    });
    column6.setCellFactory(cellFactory);
    column6.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName3(t.getNewValue());
      }
    });
    TableColumn column7 = new TableColumn("Fact");
    column7.setCellValueFactory(
        new PropertyValueFactory<Column, String>("factName4"));
    column7.setCellFactory(TextFieldTableCell.forTableColumn());
    column7.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName4(t.getNewValue());
      }
    });
    column7.setCellFactory(cellFactory);
    column7.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFactName4(t.getNewValue());
      }
    });

    TableColumn column8 = new TableColumn("Points");
    column8.setCellValueFactory(
        new PropertyValueFactory<Column, String>("pointAmount1"));
    column8.setCellFactory(TextFieldTableCell.forTableColumn());
    column8.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount1(
            t.getNewValue());
      }
    });
    column8.setCellFactory(cellFactory);
    column8.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount1(
            t.getNewValue());
      }
    });
    TableColumn column9 = new TableColumn("Points");
    column9.setCellValueFactory(
        new PropertyValueFactory<Column, String>("pointAmount2"));
    column9.setCellFactory(TextFieldTableCell.forTableColumn());
    column9.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount2(
            t.getNewValue());
      }
    });
    column9.setCellFactory(cellFactory);
    column9.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount2(
            t.getNewValue());
      }
    });
    TableColumn column10 = new TableColumn("Points");
    column10.setCellValueFactory(
        new PropertyValueFactory<Column, String>("pointAmount3"));
    column10.setCellFactory(TextFieldTableCell.forTableColumn());
    column10.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount3(
            t.getNewValue());
      }
    });
    column10.setCellFactory(cellFactory);
    column10.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount3(
            t.getNewValue());
      }
    });
    TableColumn column11 = new TableColumn("Points");
    column11.setCellValueFactory(
        new PropertyValueFactory<Column, String>("pointAmount4"));
    column11.setCellFactory(TextFieldTableCell.forTableColumn());
    column11.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount4(
            t.getNewValue());
      }
    });
    column11.setCellFactory(cellFactory);
    column11.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPointAmount4(
            t.getNewValue());
      }
    });

    TableColumn column12 = new TableColumn("Score");
    column12.setCellValueFactory(
        new PropertyValueFactory<Column, String>("scoreAmount1"));
    column12.setCellFactory(TextFieldTableCell.forTableColumn());
    column12.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount1(
            t.getNewValue());
      }
    });
    column12.setCellFactory(cellFactory);
    column12.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount1(
            t.getNewValue());
      }
    });
    TableColumn column13 = new TableColumn("Score");
    column13.setCellValueFactory(
        new PropertyValueFactory<Column, String>("scoreAmount2"));
    column13.setCellFactory(TextFieldTableCell.forTableColumn());
    column13.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount2(
            t.getNewValue());
      }
    });
    column13.setCellFactory(cellFactory);
    column13.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount2(
            t.getNewValue());
      }
    });
    TableColumn column14 = new TableColumn("Score");
    column14.setCellValueFactory(
        new PropertyValueFactory<Column, String>("scoreAmount3"));
    column14.setCellFactory(TextFieldTableCell.forTableColumn());
    column14.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount3(
            t.getNewValue());
      }
    });
    column14.setCellFactory(cellFactory);
    column14.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount3(
            t.getNewValue());
      }
    });
    TableColumn column15 = new TableColumn("Score");
    column15.setCellValueFactory(
        new PropertyValueFactory<Column, String>("scoreAmount4"));
    column15.setCellFactory(TextFieldTableCell.forTableColumn());
    column15.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount4(
            t.getNewValue());
      }
    });
    column15.setCellFactory(cellFactory);
    column15.setOnEditCommit(new EventHandler<CellEditEvent<Column, String>>()
    {
      @Override public void handle(CellEditEvent<Column, String> t)
      {
        ((Column) t.getTableView().getItems().get(t.getTablePosition().getRow())).setScoreAmount4(
            t.getNewValue());
      }
    });

    TableColumn column16 = new TableColumn("Country A");

    TableColumn column17 = new TableColumn("Country B");

    TableColumn column18 = new TableColumn("Country C");

    TableColumn column19 = new TableColumn("Home market");

    table.setItems(data);
    table.getColumns()
        .addAll(column,column0, column1, column2, column3, column16, column17, column18, column19);
    column16.getColumns().addAll(column4, column8, column12);
    column17.getColumns().addAll(column5, column9, column13);
    column18.getColumns().addAll(column6, column10, column14);
    column19.getColumns().addAll(column7, column11, column15);

    final TextField addNumber = new TextField();
    addNumber.setMaxWidth(0);
    final TextField addPartName = new TextField();
    addPartName.setPromptText("MA or CS");
    addPartName.setMaxWidth(80);
    final TextField addCriteriaName = new TextField();
    addCriteriaName.setPromptText("Criteria");
    addCriteriaName.setMaxWidth(80);
    final TextField addSourceName = new TextField();
    addSourceName.setPromptText("Source");
    addSourceName.setMaxWidth(80);
    final TextField addWeightAmount = new TextField();
    addWeightAmount.setPromptText("Weight");
    addWeightAmount.setMaxWidth(55);
    final TextField addFactName1 = new TextField();
    addFactName1.setPromptText("Fact A");
    addFactName1.setMaxWidth(60);
    final TextField addFactName2 = new TextField();
    addFactName2.setPromptText("Fact B");
    addFactName2.setMaxWidth(60);
    final TextField addFactName3 = new TextField();
    addFactName3.setPromptText("Fact C");
    addFactName3.setMaxWidth(60);
    final TextField addFactName4 = new TextField();
    addFactName4.setPromptText("Fact D");
    addFactName4.setMaxWidth(60);
    final TextField addPointAmount1 = new TextField();
    addPointAmount1.setPromptText("Point A");
    addPointAmount1.setText("0");
    addPointAmount1.setMaxWidth(55);
    final TextField addPointAmount2 = new TextField();
    addPointAmount2.setText("0");
    addPointAmount2.setPromptText("Point B");
    addPointAmount2.setMaxWidth(55);
    final TextField addPointAmount3 = new TextField();
    addPointAmount3.setText("0");
    addPointAmount3.setPromptText("Point C");
    addPointAmount3.setMaxWidth(55);
    final TextField addPointAmount4 = new TextField();
    addPointAmount4.setText("0");
    addPointAmount4.setPromptText("Point D");
    addPointAmount4.setMaxWidth(55);
    final TextField addScoreAmount1 = new TextField();
    addScoreAmount1.setPromptText("Score A");
    addScoreAmount1.setMaxWidth(55);
    final TextField addScoreAmount2 = new TextField();
    addScoreAmount2.setPromptText("Score B");
    addScoreAmount2.setMaxWidth(55);
    final TextField addScoreAmount3 = new TextField();
    addScoreAmount3.setPromptText("Score C");
    addScoreAmount3.setMaxWidth(55);
    final TextField addScoreAmount4 = new TextField();
    addScoreAmount4.setPromptText("Score D");
    addScoreAmount4.setMaxWidth(55);

    final Button addButton = new Button("Add");
    addButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override public void handle(ActionEvent e)
      {
        data.add(new Column(addNumber.getText(),addPartName.getText(), addCriteriaName.getText(),
            addSourceName.getText(),addWeightAmount.getText() ,
            addFactName1.getText(), addPointAmount1.getText(),
            addScoreAmount1.getText(), addFactName2.getText(),
            addPointAmount2.getText(), addScoreAmount2.getText(),
            addFactName3.getText(), addPointAmount3.getText(),
            addScoreAmount3.getText(), addFactName4.getText(),
            addPointAmount4.getText(), addScoreAmount4.getText()));
      }
    });

    final Button deleteButton = new Button("Delete");
    deleteButton.setOnAction(e -> {
      Column selectedItem = table.getSelectionModel().getSelectedItem();
      table.getItems().remove(selectedItem);
    });

    Button btnclear = new Button("Clear");
    btnclear.setOnAction(event -> {
      addNumber.clear();
      addPartName.clear();
      addCriteriaName.clear();
      addSourceName.clear();
      addWeightAmount.clear();
      addFactName1.clear();
      addFactName2.clear();
      addFactName3.clear();
      addFactName4.clear();
      addPointAmount1.clear();
      addPointAmount2.clear();
      addPointAmount3.clear();
      addPointAmount4.clear();
      addScoreAmount1.clear();
      addScoreAmount2.clear();
      addScoreAmount3.clear();
      addScoreAmount4.clear();
    });

    Button button = new Button("Save");
    button.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        System.out.println(" can I print?");
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob.showPrintDialog(stage) && printerJob.printPage(table))
        {
          printerJob.endJob();
          System.out.println("printed");
        }
      }
    });

    final Button hide = new Button("?");
    hide.setOnAction(event -> {
      if (label2.isVisible())
      {
        label2.setVisible(false);
      }
      else{
        label2.setVisible(true);
      }
    });

    final Button btncalculate = new Button("Calculate");
    btncalculate.setOnAction(e -> {
      float m1,m2,m3,m4,m5;

      float score1;
      float score2;
      float score3;
      float score4;

      m1 =Integer.parseInt(addWeightAmount.getText());
      m2 =Integer.parseInt(addPointAmount1.getText());
      m3 =Integer.parseInt(addPointAmount2.getText());
      m4 =Integer.parseInt(addPointAmount3.getText());
      m5 =Integer.parseInt(addPointAmount4.getText());

      score1 = m1/100 * m2;
      score2 = m1/100 * m3;
      score3 = m1/100 * m4;
      score4 = m1/100 * m5;

      addScoreAmount1.setText(String.valueOf(score1));
      addScoreAmount2.setText(String.valueOf(score2));
      addScoreAmount3.setText(String.valueOf(score3));
      addScoreAmount4.setText(String.valueOf(score4));
    });

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<Number,String> bc =
        new BarChart<Number,String>(yAxis,xAxis);
    xAxis.setLabel("Column");
    yAxis.setLabel("Score");
    XYChart.Series series1 = new XYChart.Series();

    final Button graph = new Button("Graph");
    graph.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override public void handle(ActionEvent event)
      {
        series1.getData().add(new XYChart.Data(Double.parseDouble(addScoreAmount1.getText()), countryA));
        series1.getData().add(new XYChart.Data(Double.parseDouble(addScoreAmount2.getText()), countryB));
        series1.getData().add(new XYChart.Data(Double.parseDouble(addScoreAmount3.getText()), countryC));
        series1.getData().add(new XYChart.Data(Double.parseDouble(addScoreAmount4.getText()), countryD));
      }
    });

    hb.getChildren()
        .addAll(hide, addPartName, addCriteriaName, addSourceName,addFactName1,addFactName2,addFactName3,addFactName4, addWeightAmount, addPointAmount1, addPointAmount2, addPointAmount3, addPointAmount4, addScoreAmount1, addScoreAmount2, addScoreAmount3, addScoreAmount4, btncalculate, graph, addButton, btnclear, deleteButton, button);
    hb.setSpacing(3);

    final VBox vbox = new VBox();
    vbox.setVgrow(table, Priority.ALWAYS);
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, label1, label2, hb, table);

    bc.getData().addAll(series1);
    bc.setLayoutX(0);
    bc.setLayoutY(520);
    bc.setMinWidth(1370);
    bc.setMaxHeight(224);

    ((Group) scene.getRoot()).getChildren().addAll(vbox, bc);

    stage.setScene(scene);
    stage.show();
  }
}
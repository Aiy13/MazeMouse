import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Mymaze extends Application
{
    public static void main(String[] args)
    {
        launch();
    }
    //主函数，舞台入口

    public void start(Stage stage) throws Exception {

        stage.setTitle("杰瑞逃生之路");
        stage.setWidth(600);
        stage.setHeight(600);
        Button button1 = new Button("开始");
        Button button2 = new Button("作者");
        Button button3 = new Button("退出");
        Button button4 = new Button("返回");
        Button button5 = new Button("生成杰瑞逃生之路");
        Button button6 = new Button("杰瑞快跑");
        Button button7 = new Button("算法显示");
        Button button8 = new Button("消灭脚印");
        Button button9 = new Button("脚踏实地");
        Button button10 = new Button("杰瑞不急");
        Button button11 = new Button("确认");
        Button button12 = new Button("说明");

        final int[] number = new int[1];//用于接收输入的数据




        button1.setLayoutX(250);
        button1.setLayoutY(125);
        button1.setPrefHeight(50);
        button1.setPrefWidth(81);
        //按钮1



        button2.setLayoutX(250);
        button2.setLayoutY(325);
        button2.setPrefHeight(50);
        button2.setPrefWidth(81);
        //按钮2



        button3.setLayoutX(250);
        button3.setLayoutY(425);
        button3.setPrefHeight(50);
        button3.setPrefWidth(81);
        //按钮3



        button4.setLayoutX(100);
        button4.setLayoutY(400);
        button4.setPrefHeight(50);
        button4.setPrefWidth(81);
        //按钮4




        button5.setLayoutX(205);
        button5.setLayoutY(100);
        button5.setPrefHeight(50);
        button5.setPrefWidth(200);
        //按钮5




        button11.setLayoutX(450);
        button11.setLayoutY(400);
        button11.setPrefHeight(50);
        button11.setPrefWidth(81);
        //按钮11



        button12.setLayoutX(250);
        button12.setLayoutY(225);
        button12.setPrefHeight(50);
        button12.setPrefWidth(81);
        //按钮12



        Group group = new Group();
        Image backgroundImage = new Image("background1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        //图片1






        group.getChildren().add(backgroundImageView);
        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(button3);
        group.getChildren().add(button12);


        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();


        

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image backgroundImage = new Image("background1.jpg");
                ImageView backgroundImageView = new ImageView(backgroundImage);
                //配置新的背景图

                group.getChildren().add(backgroundImageView);
                group.getChildren().add(button4);
                //增加返回按键，程序可重用性高
                group.getChildren().add(button11);

                TextField field = new TextField(); // 创建一个单行输入框
                field.setPrefSize(200, 50);//设定宽高
                field.setEditable(true); // 设置单行输入框能否编辑
                field.setPromptText("请决定杰瑞要跑多大的迷宫");
//                field.setAlignment(Pos.CENTER_LEFT); // 设置单行输入框的对齐方式
                field.setPrefColumnCount(11); // 设置单行输入框的推荐列数
                field.setLayoutX(200);
                field.setLayoutY(100);
                group.getChildren().addAll(field);


                button11.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = field.getText();
                        try{
                            int n = Integer.parseInt(str);

                            number[0] = n;

                            if(n>49)
                            {
                                throw new MyException1();
                            }
                            else if(n<10)
                            {
                                throw new MyException2();
                            }
                            Image backgroundImage1 = new Image("background5.jpg");
                            ImageView backgroundImageView1 = new ImageView(backgroundImage1);
                            backgroundImageView1.setFitHeight(600);
                            backgroundImageView1.setFitWidth(600);
                            group.getChildren().add(backgroundImageView1);
                            //配置新的背景图
                            group.getChildren().add(button5);

                        }
                        catch (NumberFormatException e)
                        {
                            Image backgroundImage1 = new Image("background3.jpg");
                            ImageView backgroundImageView1 = new ImageView(backgroundImage1);
                            backgroundImageView1.setFitHeight(600);
                            backgroundImageView1.setFitWidth(600);
                            group.getChildren().add(backgroundImageView1);
                            //配置新的背景图


                            Button button = new Button("您的数据类型出错了，点我返回");
                            button.setLayoutX(175);
                            button.setLayoutY(400);
                            button.setPrefHeight(50);
                            button.setPrefWidth(50);
                            button.setPrefWidth(300);
                            group.getChildren().add(button);


                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        group.getChildren().clear();
                                        start(stage);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });//button ：返回 回到主界面，重新调用方法

                        }
                        catch (MyException1 e)
                        {
                            Image backgroundImage1 = new Image("background2.jpg");
                            ImageView backgroundImageView1 = new ImageView(backgroundImage1);
                            backgroundImageView1.setFitHeight(600);
                            backgroundImageView1.setFitWidth(600);
                            group.getChildren().add(backgroundImageView1);

                            Button button = new Button("太大了，杰瑞真的会谢，小于49");
                            button.setLayoutX(175);
                            button.setLayoutY(400);
                            button.setPrefHeight(50);
                            button.setPrefWidth(50);
                            button.setPrefWidth(300);
                            group.getChildren().add(button);


                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        group.getChildren().clear();
                                        start(stage);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });//button ：返回 回到主界面，重新调用方法
                        }
                        catch (MyException2 e)
                        {
                            Image backgroundImage1 = new Image("background6.jpg");
                            ImageView backgroundImageView1 = new ImageView(backgroundImage1);
                            backgroundImageView1.setFitHeight(600);
                            backgroundImageView1.setFitWidth(600);
                            group.getChildren().add(backgroundImageView1);

                            Button button = new Button("太小了，杰瑞真的会哭，大于10");
                            button.setLayoutX(175);
                            button.setLayoutY(200);
                            button.setPrefHeight(50);
                            button.setPrefWidth(50);
                            button.setPrefWidth(300);
                            group.getChildren().add(button);



                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        group.getChildren().clear();
                                        start(stage);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });//button ：返回 回到主界面，重新调用方法
                        }
                    }
                });
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                Image backgroundImage = new Image("background4.jpg");
                ImageView backgroundImageView = new ImageView(backgroundImage);
                group.getChildren().add(backgroundImageView);
                backgroundImageView.setFitHeight(600);
                backgroundImageView.setFitWidth(600);
                group.getChildren().add(button4);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.close();
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                try {
                    group.getChildren().clear();

                    
                    start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //调用启动函数，回到主界面
            }

        });
        button12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Image backgroundImage = new Image("background7.jpg");
                ImageView backgroundImageView = new ImageView(backgroundImage);
                group.getChildren().add(backgroundImageView);
                backgroundImageView.setFitHeight(600);
                backgroundImageView.setFitWidth(600);
                group.getChildren().add(button4);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int n = number[0];



                try {
                    File file = new File("music.wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                    AudioFormat format = audioStream.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    Clip clip = (Clip) AudioSystem.getLine(info);
                    clip.open(audioStream);
                    clip.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }




                group.getChildren().clear();
                FlowPane flowpane = new FlowPane();
                Gezi[][] gezi = new Gezi[n][n];
                Stack<Point> stack1 = new Stack<>();
                Point Startpoint1 = new Point(1, 1);
                stack1.add(Startpoint1);
                Random random = new Random();
                ArrayList<Gezi> way = new ArrayList<>();
                ArrayList<Gezi> wall = new ArrayList<>();
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        gezi[i][j] = new Gezi(i, j, true,false);        //true为墙false为路
                    }
                }
                for(int i=1;i<=n-2;i+=2)
                {
                    for(int j=1;j<=n-2;j+=2)
                    {
                        gezi[i][j].setFilled(false);
                        way.add(gezi[i][j]);
                    }
                }
                gezi[0][1].setStart(true);
                gezi[n-1][n-2].setEnd(true);
                gezi[n-2][n-2].setFilled(false);
                gezi[n-3][n-2].setFilled(false);
                gezi[n-1][n-2].setFilled(false);
                gezi[0][1].setFilled(false);
                //预处理，防止程序崩溃



                ArrayList<Gezi> search = new ArrayList<>();
                int startX = 1;
                int startY = 1;
                gezi[startX][startY].setSearched(true);
                search.add(gezi[startX][startY]);
                Image image = new Image("background8.jpg");
                ImagePattern pattern = new ImagePattern(image);

                //支持pattern
                while(true)
                {
                    if(gezi[startX+1][startY].isFilled())
                    {
                        if(startX+1<(n-1))
                            wall.add(gezi[startX+1][startY]);
                    }
                    if(gezi[startX-1][startY].isFilled())
                    {
                        if(startX-1>0)
                            wall.add(gezi[startX-1][startY]);
                    }
                    if(gezi[startX][startY+1].isFilled())
                    {
                        if(startY+1<(n-1))
                            wall.add(gezi[startX][startY+1]);
                    }
                    if(gezi[startX][startY-1].isFilled())
                    {
                        if(startY-1>0)
                            wall.add(gezi[startX][startY-1]);
                    }
                    int n1 = random.nextInt(wall.size());
                    int n2 = 0;
                    if(gezi[wall.get(n1).getX()-1][wall.get(n1).getY()].isSearched())
                    {
                        n2++;
                    }
                    if(gezi[wall.get(n1).getX()+1][wall.get(n1).getY()].isSearched())
                    {
                        n2++;
                    }
                    if(gezi[wall.get(n1).getX()][wall.get(n1).getY()-1].isSearched())
                    {
                        n2++;
                    }
                    if(gezi[wall.get(n1).getX()][wall.get(n1).getY()+1].isSearched())
                    {
                        n2++;
                    }
                    if(n2==2)
                    {
                        wall.remove(n1);
                    }
                    else
                    {
                        if(!gezi[wall.get(n1).getX()-1][wall.get(n1).getY()].isFilled())
                        {
                            if(!gezi[wall.get(n1).getX()-1][wall.get(n1).getY()].isSearched())
                            {
                                gezi[wall.get(n1).getX()-1][wall.get(n1).getY()].setSearched(true);
                                search.add(gezi[wall.get(n1).getX()-1][wall.get(n1).getY()]);
                                startX = wall.get(n1).getX()-1;
                                startY = wall.get(n1).getY();
                            }
                        }
                        if(!gezi[wall.get(n1).getX()+1][wall.get(n1).getY()].isFilled())
                        {
                            if(!gezi[wall.get(n1).getX()+1][wall.get(n1).getY()].isSearched())
                            {
                                gezi[wall.get(n1).getX()+1][wall.get(n1).getY()].setSearched(true);
                                search.add(gezi[wall.get(n1).getX()+1][wall.get(n1).getY()]);
                                startX = wall.get(n1).getX()+1;
                                startY = wall.get(n1).getY();
                            }
                        }
                        if(!gezi[wall.get(n1).getX()][wall.get(n1).getY()-1].isFilled())
                        {
                            if(!gezi[wall.get(n1).getX()][wall.get(n1).getY()-1].isSearched())
                            {
                                gezi[wall.get(n1).getX()][wall.get(n1).getY()-1].setSearched(true);
                                search.add(gezi[wall.get(n1).getX()][wall.get(n1).getY()-1]);
                                startX = wall.get(n1).getX();
                                startY = wall.get(n1).getY()-1;
                            }
                        }
                        if(!gezi[wall.get(n1).getX()][wall.get(n1).getY()+1].isFilled())
                        {
                            if(!gezi[wall.get(n1).getX()][wall.get(n1).getY()+1].isSearched())
                            {
                                gezi[wall.get(n1).getX()][wall.get(n1).getY()+1].setSearched(true);
                                search.add(gezi[wall.get(n1).getX()][wall.get(n1).getY()+1]);
                                startX = wall.get(n1).getX();
                                startY = wall.get(n1).getY()+1;
                            }
                        }
                        gezi[wall.get(n1).getX()][wall.get(n1).getY()].setFilled(false);
                        wall.remove(n1);
                    }
                    if(search.size()==way.size())
                        break;
                }
                flowpane.setPrefSize(20*n, 20*n);


                Image image1 = new Image("background9.jpg");
                ImagePattern pattern1 = new ImagePattern(image1);


                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(!gezi[i][j].isFilled())            //路
                        {
                            Rectangle rectangle = new Rectangle();

                            rectangle.setWidth(20);
                            rectangle.setHeight(20);


                            if(gezi[i][j].isStart())
                            {
                                rectangle.setFill(pattern1);
                            }
                            else if(gezi[i][j].isEnd())
                            {
                                rectangle.setFill(Color.YELLOW);
                            }
                            else
                                rectangle.setFill(Color.WHITE);
                            flowpane.getChildren().add(rectangle);
                        }
                        else               //墙
                        {
                            Rectangle rectangle = new Rectangle();
                            rectangle.setWidth(20);
                            rectangle.setHeight(20);

                            rectangle.setFill(pattern);
                            flowpane.getChildren().add(rectangle);
                        }
                    }
                }





                group.getChildren().add(flowpane);
                stage.setWidth(n*20+200);
                stage.setHeight(n*20+100);
                //窗口根据迷宫大小变化大小

                button4.setLayoutX(n*20+50);
                button4.setLayoutY(n*20-20);
                button4.setPrefHeight(50);
                button4.setPrefWidth(81);
                //重新设置返回按钮



                button6.setLayoutX(n*20+50);
                button6.setLayoutY(20);
                button6.setPrefHeight(50);
                button6.setPrefWidth(81);
                //button6根据迷宫大小变化位置



                button7.setLayoutX(n*20+50);
                button7.setLayoutY(n*10+20);
                button7.setPrefHeight(50);
                button7.setPrefWidth(81);
                //button7的位置变化


                button8.setLayoutX(n*20+50);
                button8.setLayoutY(n*20-80);
                button8.setPrefHeight(50);
                button8.setPrefWidth(81);




                button10.setLayoutX(n*20+50);
                button10.setLayoutY(n*10+15+20);
                button10.setPrefHeight(50);
                button10.setPrefWidth(81);


                button9.setLayoutX(n*20+50);
                button9.setLayoutY(100);
                button9.setPrefHeight(50);
                button9.setPrefWidth(81);






                //group.getChildren().add(button7);已被弃用
                group.getChildren().add(button8);
                group.getChildren().add(button9);
                group.getChildren().add(button10);
                group.getChildren().add(button6);
                group.getChildren().add(button4);



                button6.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        Point Startpoint = new Point(1, 1);
                        Point Endpoint = new Point(n-2, n-2);
                        for(int i=0;i<n;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                gezi[i][j].setGo(false);
                                gezi[i][j].setColored(false);
                            }
                        }
                        int x = 0;
                        int y = 0;
                        Stack<Point> stack = new Stack<>();
                        stack.add(Startpoint);
                        gezi[Startpoint.x][Startpoint.y].setGo(true);
                        int count=0;
                        while(!stack.empty())
                        {
                            Point point1 = stack.pop();              //重点，（回溯）
                            int flag = 0;
                            for(int i=0;i<4;i++)
                            {
                                switch(i)
                                {
                                    case 0: x = point1.x+1;        //向下
                                        y = point1.y;
                                        break;
                                    case 1: x = point1.x;          //向右
                                        y = point1.y+1;
                                        break;
                                    case 2: x = point1.x;          //向左
                                        y = point1.y-1;
                                        break;
                                    case 3: x = point1.x-1;       //向上
                                        y = point1.y;
                                        break;
                                }
                                if(!gezi[x][y].isFilled()&&!gezi[x][y].isGo())
                                {
                                    gezi[x][y].setGo(true);
                                    stack.push(point1);
                                    stack.push(new Point(x,y));
                                    if(x == Endpoint.x&&y == Endpoint.y)           //到达终点
                                    {
                                        flag = 1;
                                    }
                                    break;
                                }
                            }
                            if(flag == 1)                   //到达终点退出
                                break;

                        }
                        for(int i=0;i<stack.size();i++)
                        {
                            gezi[stack.get(i).x][stack.get(i).y].setColored(true);
                        }
                        flowpane.getChildren().clear();


                        Image image = new Image("background8.jpg");
                        ImagePattern pattern = new ImagePattern(image);

                        //支持pattern

                        gezi[0][1].setColored(false);
                        gezi[n-1][n-2].setColored(false);

                        gezi[0][1].setColored(true);
                        gezi[n-1][n-2].setColored(true);


                        Image image2 = new Image("background10.jpg");
                        ImagePattern pattern2 = new ImagePattern(image2);


                        for(int i=0;i<n;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                if(!gezi[i][j].isFilled())            //路
                                {
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setWidth(20);
                                    rectangle.setHeight(20);
                                    if(gezi[i][j].isColored())
                                    {
                                        rectangle.setFill(pattern2);
                                        count++;
                                    }
                                    else
                                    {
                                        rectangle.setFill(Color.WHITE);
                                    }
                                    flowpane.getChildren().add(rectangle);
                                }
                                else               //墙
                                {
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setWidth(20);
                                    rectangle.setHeight(20);

                                    rectangle.setFill(pattern);
                                    flowpane.getChildren().add(rectangle);
                                }
                            }
                        }
                        for(int i=0;i<n;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                gezi[i][j].setGo(false);
                                gezi[i][j].setColored(false);;
                            }
                        }
                        String str = "杰瑞逃跑一共花了"+count+"步";
                        Text text = new Text(str);
                        text.setLayoutX(n*20+10);
                        text.setLayoutY(n*10);
                        group.getChildren().add(text);
                    }


                });


                button8.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        button10.setDisable(false);
                        for(int i=0;i<n;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                gezi[i][j].setGo(false);
                                gezi[i][j].setColored(false);
                            }
                        }
                        Image image = new Image("background8.jpg");
                        ImagePattern pattern = new ImagePattern(image);
                        Image image1 = new Image("background9.jpg");
                        ImagePattern pattern1 = new ImagePattern(image1);




                        stack1.clear();
                        stack1.add(Startpoint1);
                        flowpane.getChildren().clear();
                        for(int i=0;i<n;i++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                if(!gezi[i][j].isFilled())            //路
                                {
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setWidth(20);
                                    rectangle.setHeight(20);
                                   /*
                                    else if(gezi[i][j].isEnd())
                                    {
                                        rectangle.setFill(Color.YELLOW);
                                    }*/

                                        rectangle.setFill(Color.WHITE);
                                    flowpane.getChildren().add(rectangle);
                                }
                                else               //墙
                                {
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setWidth(20);
                                    rectangle.setHeight(20);


                                    //支持pattern
                                    rectangle.setFill(pattern);
                                    flowpane.getChildren().add(rectangle);
                                }
                            }
                        }
                    }
                });

                button9.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {


                        Image image = new Image("background8.jpg");
                        ImagePattern pattern = new ImagePattern(image);
                        Image image2 = new Image("background10.jpg");
                        ImagePattern pattern2 = new ImagePattern(image2);

                        int x = 0;
                        int y = 0;


                        gezi[Startpoint1.x][Startpoint1.y].setGo(true);
                        Point point1 = stack1.pop();              //重点，（回溯）

                        gezi[point1.x][point1.y].setColored(false);

                        gezi[point1.x][point1.y].setIs(false);
                        for (int i = 0; i < 4; i++) {
                            switch (i) {
                                case 0:
                                    x = point1.x + 1;        //向下
                                    y = point1.y;
                                    break;
                                case 1:
                                    x = point1.x;          //向右
                                    y = point1.y + 1;
                                    break;
                                case 2:
                                    x = point1.x;          //向左
                                    y = point1.y - 1;
                                    break;
                                case 3:
                                    x = point1.x - 1;       //向上
                                    y = point1.y;
                                    break;
                            }



                                if (!gezi[x][y].isFilled() && !gezi[x][y].isGo()) {
                                    gezi[x][y].setGo(true);


                                    stack1.push(point1);
                                    stack1.push(new Point(x, y));
                                    break;


                            }
                        }
                        for (int i = 0; i < stack1.size(); i++) {
                            gezi[stack1.get(i).x][stack1.get(i).y].setColored(true);
                        }
                        flowpane.getChildren().clear();
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (!gezi[i][j].isFilled())            //路
                                {
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setWidth(20);
                                    rectangle.setHeight(20);
                                    if (gezi[i][j].isColored()) {
                                        rectangle.setFill(pattern2);
                                    } else {
                                        rectangle.setFill(Color.WHITE);
                                    }
                                    flowpane.getChildren().add(rectangle);
                                } else               //墙
                                {
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setWidth(20);
                                    rectangle.setHeight(20);
                                    rectangle.setFill(pattern);
                                    flowpane.getChildren().add(rectangle);
                                }
                            }
                        }
                    }

                });
                button10.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {


                        try {
                            PauseTransition pause = new PauseTransition(Duration.millis(50)); // 长按时间为50ms
                            pause.setOnFinished(evt -> {
                                button9.fire(); // 触发按钮事件
                                pause.playFromStart(); // 重新开始暂停过渡
                            });

                            button10.setOnMousePressed(evt -> {
                                pause.play(); // 开始暂停过渡
                                button10.setDisable(true);


                            });

                            if (!gezi[n - 1][n - 2].isIs()) {
                                pause.stop();
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            button10.setDisable(false);
                        }



                    }
                });
            }
        });
    }
}
class MyException1 extends Exception{

    private int detail;

    public MyException1(){
    }
    //异常的打印信息
    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
class MyException2 extends Exception{

    private int detail;

    public MyException2(){
    }
    //异常的打印信息
    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
class Point
{
    int x;
    int y;
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Point()
    {

    }
    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
class Gezi
{
    private int x;
    private int y;
    private boolean filled;
    private boolean searched;
    private boolean colored;
    private boolean go;
    private boolean start;
    private boolean end;
    private boolean is;
    public boolean isStart() {
        return start;
    }
    public void setStart(boolean start) {

        this.start = start;
    }
    public boolean isEnd() {
        return end;
    }
    public void setEnd(boolean end) {
        this.end = end;
    }
    public boolean isGo() {
        return go;
    }
    public void setGo(boolean go) {
        this.go = go;
    }
    public void setIs(boolean is)
    {
        this.is = is;
    }
    public boolean isIs()
    {
        return is;
    }
    public boolean isColored() {

        return colored;
    }
    public void setColored(boolean colored) {

        this.colored = colored;
    }
    public int getX() {

        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {

        return y;
    }
    public void setY(int y) {

        this.y = y;
    }
    public boolean isFilled() {

        return filled;
    }
    public void setFilled(boolean filled) {

        this.filled = filled;
    }
    public boolean isSearched() {

        return searched;
    }
    public void setSearched(boolean searched) {

        this.searched = searched;
    }
    public Gezi()
    {

    }
    public Gezi(int x,int y,boolean filled,boolean searched)
    {
        this.filled = filled;
        this.x = x;
        this.y = y;
        this.searched = searched;
    }
}

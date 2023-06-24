package gradingsystem;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;  
public class GradingSystem extends JFrame implements ActionListener {
 //PREPARING VARIABLES
    int Counter, CourseGradeCounter = 0, SelectedTaskType, SubjectGradeCounter = 0;
    double SMCategoryMultiplier1, SMCategoryMultiplier2, SMCategoryMultiplier3, TotalPercentage, Calculation1, Calculation2, Calculation3;
    double LowestGrade, FinalGrade, CollegeGrade;
    double Test1, Test2, Test3;
    double CMInput1, CMInput2, TotalHomeworkGradedScore, TotalLaboratoryGradedScore, TotalExaminationGradedScore, TotalHomeworkTotalScore, TotalLaboratoryTotalScore, TotalExaminationTotalScore;
    boolean SuccessfulCalculation = false;
    String AcquiredGradeData, Percentage1, Percentage2, Percentage3, SetTaskType, EquivSTT, Input1A, Input1B, Input2;
    double NumericalAcquiredGradeData, TotalAccumulatedGrade = 0;
    String TaskTypes[]={"Homework","Laboratory","Examination"};      
    //DEFINING DESIGN PARAMETERS
    Color BGCOLOR = new Color(200,250,255);
    Color CYAN = new Color(15,85,100);
    Color BUTTONBG = new Color (70,220,175);
    Font ARIAL = new Font("Arial", Font.PLAIN, 10);
    Font ARIALBIGGER = new Font("Arial", Font.BOLD, 12);
    Font ARIALBOLD = new Font("Arial", Font.BOLD, 15);
    Font ARIALBIGBOLD = new Font("Arial", Font.BOLD, 13);
    Font TAHOMABIG = new Font("Tahoma", Font.BOLD, 20);
    Font TAHOMASMALL = new Font("TahomaS", Font.ITALIC, 15);
    //PREPARING UI
    JFrame FRMGradingSystem = new JFrame("Grade Calculatron");
    JFrame FRMWarning = new JFrame("Warning!");
    JTextField tfpercent1, tfpercent2, tfpercent3, tfinput1A, tfinput1B, tfinput2;
    JButton btcancel, btadd1, btadd2, btremove1, btremove2, btexit, btmode1, btmode2, btok, btconfirm;
    JLabel LBLHeader, LBLSubHeader, LBLChooseMode, LBLSelectedMode1, LBLSelectedMode2, LBLGradedScore, LBLTotalScore, LBLTaskType, LBLFinalCourseGrade1, LBLFinalCourseGrade2, LBLGrade, LBLWarning, LBLFinalGradeText, LBLFinalGradeResult, LBLAnalysis,LBLAward2A, LBLAward2B, LBLLowestGradeText, LBLLowestGrade, LBLHomework, LBLLaboratory, LBLExamination, LBLDescriptiveRating, LBLAcademicAward, LBLDistinctionAward;
    DefaultTableModel ScoreData = new DefaultTableModel();
    DefaultTableModel GradeData = new DefaultTableModel();
    JTable TDisplayData1 = new JTable(ScoreData);
    JTable TDisplayData2 = new JTable(GradeData);
    JComboBox CBTaskType;
    private static final DecimalFormat TwoDecimal = new DecimalFormat("0.00");  
    public void GradingSystem(){
        //INITIALIZING UI
        FRMGradingSystem.setSize(400,300);
        FRMGradingSystem.setResizable(false);
        FRMGradingSystem.setLayout(null);
        FRMGradingSystem.setLocationRelativeTo(null);
        FRMGradingSystem.getContentPane().setBackground(BGCOLOR);
        FRMWarning.setSize(300,100);
        FRMWarning.setLayout(null);
        FRMWarning.setLocationRelativeTo(null);
        FRMWarning.getContentPane().setBackground(BGCOLOR);
        LBLHeader = new JLabel();
        LBLHeader.setText("GRADE CALCULATRON");
        LBLHeader.setBounds(85,15,230,50);
        LBLHeader.setFont(TAHOMABIG);
        LBLHeader.setForeground(CYAN);
        LBLHeader.setHorizontalAlignment(JLabel.CENTER);
        LBLHeader.setVisible(true);
        LBLSubHeader = new JLabel();
        LBLSubHeader.setText("Bataan Peninsula State University");
        LBLSubHeader.setBounds(85,35,230,50);
        LBLSubHeader.setFont(TAHOMASMALL);
        LBLSubHeader.setForeground(CYAN);
        LBLSubHeader.setHorizontalAlignment(JLabel.CENTER);
        LBLSubHeader.setVisible(true);
        LBLChooseMode = new JLabel();
        LBLChooseMode.setText("CHOOSE MODE");
        LBLChooseMode.setBounds(100,100,200,50);
        LBLChooseMode.setFont(ARIALBOLD);
        LBLChooseMode.setForeground(CYAN);
        LBLChooseMode.setHorizontalAlignment(JLabel.CENTER);
        LBLChooseMode.setVisible(true);
        LBLWarning = new JLabel();
        LBLWarning.setText("");
        LBLWarning.setBounds(50,0,200,50);
        LBLWarning.setFont(ARIALBIGBOLD);
        LBLWarning.setForeground(CYAN);
        LBLWarning.setHorizontalAlignment(JLabel.CENTER);
        LBLWarning.setVisible(true);
        LBLSelectedMode1 = new JLabel();
        LBLSelectedMode1.setText("");
        LBLSelectedMode1.setBounds(100,0,200,50);
        LBLSelectedMode1.setFont(TAHOMABIG);
        LBLSelectedMode1.setForeground(CYAN);
        LBLSelectedMode1.setHorizontalAlignment(JLabel.CENTER);
        LBLSelectedMode1.setVisible(false);
        LBLSelectedMode2 = new JLabel();
        LBLSelectedMode2.setText("");
        LBLSelectedMode2.setBounds(100,0,200,50);
        LBLSelectedMode2.setFont(TAHOMABIG);
        LBLSelectedMode2.setForeground(CYAN);
        LBLSelectedMode2.setVisible(false);
        LBLHomework = new JLabel();
        LBLHomework.setText("Homework");
        LBLHomework.setBounds(20,30,80,50);
        LBLHomework.setFont(ARIALBIGBOLD);
        LBLHomework.setForeground(CYAN);
        LBLHomework.setVisible(false);
        LBLLaboratory = new JLabel();
        LBLLaboratory.setText("Laboratory");
        LBLLaboratory.setBounds(100,30,80,50);
        LBLLaboratory.setFont(ARIALBIGBOLD);
        LBLLaboratory.setForeground(CYAN);
        LBLLaboratory.setVisible(false);
        LBLExamination = new JLabel();
        LBLExamination.setText("Examination");
        LBLExamination.setBounds(180,30,80,50);
        LBLExamination.setFont(ARIALBIGBOLD);
        LBLExamination.setForeground(CYAN);
        LBLExamination.setHorizontalAlignment(JLabel.CENTER);
        LBLExamination.setVisible(false);
        LBLGradedScore = new JLabel();
        LBLGradedScore.setText("SCORE");
        LBLGradedScore.setBounds(20,75,100,50);
        LBLGradedScore.setFont(ARIALBIGBOLD);
        LBLGradedScore.setForeground(CYAN);
        LBLGradedScore.setHorizontalAlignment(JLabel.CENTER);
        LBLGradedScore.setVisible(false);
        LBLTotalScore = new JLabel();
        LBLTotalScore.setText("TOTAL SCORE");
        LBLTotalScore.setBounds(133,75,100,50);
        LBLTotalScore.setFont(ARIALBIGBOLD);
        LBLTotalScore.setForeground(CYAN);
        LBLTotalScore.setHorizontalAlignment(JLabel.CENTER);
        LBLTotalScore.setVisible(false);
        LBLGrade = new JLabel();
        LBLGrade.setText("GRADE");
        LBLGrade.setBounds(25,45,100,50);
        LBLGrade.setFont(ARIALBIGBOLD);
        LBLGrade.setForeground(CYAN);
        LBLGrade.setHorizontalAlignment(JLabel.CENTER);
        LBLGrade.setVisible(false);
        LBLTaskType = new JLabel();
        LBLTaskType.setText("TASKTYPE");
        LBLTaskType.setBounds(225,75,150,50);
        LBLTaskType.setFont(ARIALBIGBOLD);
        LBLTaskType.setForeground(CYAN);
        LBLTaskType.setHorizontalAlignment(JLabel.CENTER);
        LBLTaskType.setVisible(false);
        LBLFinalGradeText = new JLabel();
        LBLFinalGradeText.setText("FINAL GRADE:");
        LBLFinalGradeText.setBounds(10,370,150,50);
        LBLFinalGradeText.setFont(TAHOMASMALL);
        LBLFinalGradeText.setForeground(CYAN);
        LBLFinalGradeText.setHorizontalAlignment(JLabel.CENTER);
        LBLFinalGradeText.setVisible(false);
        LBLFinalGradeResult = new JLabel();
        LBLFinalGradeResult.setText("Complete Input");
        LBLFinalGradeResult.setBounds(115,370,175,50);
        LBLFinalGradeResult.setFont(TAHOMABIG);
        LBLFinalGradeResult.setForeground(CYAN);
        LBLFinalGradeResult.setHorizontalAlignment(JLabel.CENTER);
        LBLFinalGradeResult.setVisible(false);
        LBLDescriptiveRating = new JLabel();
        LBLDescriptiveRating.setText("Descriptive Rating: ");
        LBLDescriptiveRating.setBounds(30,410,110,50);
        LBLDescriptiveRating.setFont(ARIALBIGGER);
        LBLDescriptiveRating.setForeground(CYAN);
        LBLDescriptiveRating.setVisible(false);
        LBLAnalysis = new JLabel();
        LBLAnalysis.setText("");
        LBLAnalysis.setBounds(140,410,320,50);
        LBLAnalysis.setFont(ARIALBIGGER);
        LBLAnalysis.setForeground(CYAN);
        LBLAnalysis.setVisible(false);
        LBLLowestGradeText = new JLabel();
        LBLLowestGradeText.setText("Lowest Grade: ");
        LBLLowestGradeText.setBounds(30,390,320,50);
        LBLLowestGradeText.setFont(ARIALBIGGER);
        LBLLowestGradeText.setForeground(CYAN);
        LBLLowestGradeText.setVisible(false);
        LBLLowestGrade = new JLabel();
        LBLLowestGrade.setText("");
        LBLLowestGrade.setBounds(120,390,320,50);
        LBLLowestGrade.setFont(ARIALBIGGER);
        LBLLowestGrade.setForeground(CYAN);
        LBLLowestGrade.setVisible(false);
        LBLAcademicAward = new JLabel();
        LBLAcademicAward.setText("Academic Award: ");
        LBLAcademicAward.setBounds(30,430,110,50);
        LBLAcademicAward.setFont(ARIALBIGGER);
        LBLAcademicAward.setForeground(CYAN);
        LBLAcademicAward.setVisible(false);
        LBLAward2A = new JLabel();
        LBLAward2A.setText("");
        LBLAward2A.setBounds(140,430,320,50);
        LBLAward2A.setFont(ARIALBIGGER);
        LBLAward2A.setForeground(CYAN);
        LBLAward2A.setVisible(false);
        LBLDistinctionAward = new JLabel();
        LBLDistinctionAward.setText("Distinction Award: ");
        LBLDistinctionAward.setBounds(30,450,110,50);
        LBLDistinctionAward.setFont(ARIALBIGGER);
        LBLDistinctionAward.setForeground(CYAN);
        LBLDistinctionAward.setVisible(false);
        LBLAward2B = new JLabel();
        LBLAward2B.setText("");
        LBLAward2B.setBounds(140,450,320,50);
        LBLAward2B.setFont(ARIALBIGGER);
        LBLAward2B.setForeground(CYAN);
        LBLAward2B.setVisible(false);
        LBLFinalCourseGrade1 = new JLabel();
        LBLFinalCourseGrade1.setText("Final Grade: ");
        LBLFinalCourseGrade1.setBounds(20,480,150,50);
        LBLFinalCourseGrade1.setFont(TAHOMASMALL);
        LBLFinalCourseGrade1.setForeground(CYAN);
        LBLFinalCourseGrade1.setVisible(false);
        LBLFinalCourseGrade2 = new JLabel();
        LBLFinalCourseGrade2.setText("Incomplete Input");
        LBLFinalCourseGrade2.setBounds(120,480,320,50);
        LBLFinalCourseGrade2.setFont(TAHOMABIG);
        LBLFinalCourseGrade2.setForeground(CYAN);
        LBLFinalCourseGrade2.setVisible(false);
        btmode1 = new JButton("Course Average");
        btmode1.setBounds(125,140,150,30);
        btmode1.setBackground(BUTTONBG);
        btmode1.setForeground(CYAN);
        btmode1.setFont(ARIALBIGBOLD);
        btmode1.addActionListener(this);
        btmode1.setVisible(true);
        btmode2 = new JButton("Overall Average");
        btmode2.setBounds(125,175,150,30);
        btmode2.setBackground(BUTTONBG);
        btmode2.setForeground(CYAN);
        btmode2.setFont(ARIALBIGBOLD);
        btmode2.addActionListener(this);
        btmode2.setVisible(true);
        btadd1 = new JButton("Add");
        btadd1.setBounds(20,150,270,25);
        btadd1.setBackground(BUTTONBG);
        btadd1.setForeground(CYAN);
        btadd1.addActionListener(this);
        btadd1.setVisible(false);
        btadd2 = new JButton("Add");
        btadd2.setBounds(170,85,70,20);
        btadd2.setBackground(BUTTONBG);
        btadd2.setForeground(CYAN);
        btadd2.addActionListener(this);
        btadd2.setVisible(false);
        btconfirm = new JButton("Confirm");
        btconfirm.setBounds(280,65,80,20);
        btconfirm.setBackground(BUTTONBG);
        btconfirm.setForeground(CYAN);
        btconfirm.addActionListener(this);
        btconfirm.setVisible(false);
        btremove1 = new JButton("Delete");
        btremove1.setBounds(295,150,70,25);
        btremove1.setBackground(BUTTONBG);
        btremove1.setForeground(CYAN);
        btremove1.addActionListener(this);
        btremove1.setVisible(false);
        btremove2 = new JButton("Delete");
        btremove2.setBounds(250,85,70,20);
        btremove2.setBackground(BUTTONBG);
        btremove2.setForeground(CYAN);
        btremove2.addActionListener(this);
        btremove2.setVisible(false);
        btcancel = new JButton("Cancel");
        btcancel.setBounds(200,525,80,20);
        btcancel.setBackground(BUTTONBG);
        btcancel.setForeground(CYAN);
        btcancel.addActionListener(this);
        btcancel.setVisible(false);
        btexit = new JButton("Exit");
        btexit.setBounds(290,225,80,20);
        btexit.setBackground(BUTTONBG);
        btexit.setForeground(CYAN);
        btexit.addActionListener(this);
        btexit.setVisible(true);
        btok = new JButton("OK");
        btok.setBounds(100,35,100,20);
        btok.setBackground(BUTTONBG);
        btok.setForeground(CYAN);
        btok.addActionListener(this);
        btok.setVisible(true);
        tfpercent1 = new JTextField();
        tfpercent1.setBounds(30,65,50,20);
        tfpercent1.setForeground(CYAN);
        tfpercent1.setVisible(false);
        tfpercent2 = new JTextField();
        tfpercent2.setBounds(110,65,50,20);
        tfpercent2.setForeground(CYAN);
        tfpercent2.setVisible(false);
        tfpercent3 = new JTextField();
        tfpercent3.setBounds(190,65,50,20);
        tfpercent3.setForeground(CYAN);
        tfpercent3.setVisible(false);
        tfinput1A = new JTextField();
        tfinput1A.setBounds(20,110,100,30);
        tfinput1A.setForeground(CYAN);
        tfinput1A.setVisible(false);
        tfinput1B = new JTextField();
        tfinput1B.setBounds(133,110,100,30);
        tfinput1B.setForeground(CYAN);
        tfinput1B.setVisible(false);
        tfinput2 = new JTextField();
        tfinput2.setBounds(25,80,100,30);
        tfinput2.setForeground(CYAN);
        tfinput2.setVisible(false);
        CBTaskType = new JComboBox(TaskTypes);
        CBTaskType.setBounds(238,110,125,30);
        CBTaskType.setVisible(true);
        CBTaskType.addActionListener(this);
        CBTaskType.setVisible(false);
        ScoreData.addColumn("INDEX");
        ScoreData.addColumn("GRADED SCORE");
        ScoreData.addColumn("TOTAL SCORE");
        ScoreData.addColumn("TASKTYPE");
        TDisplayData1.setBounds(20,190,345,280);
        TDisplayData1.getColumnModel().getColumn(0).setPreferredWidth(20);
        TDisplayData1.getColumnModel().getColumn(1).setPreferredWidth(40);
        TDisplayData1.getColumnModel().getColumn(2).setPreferredWidth(40);
        TDisplayData1.setVisible(true);
        TDisplayData1.setVisible(false);
        GradeData.addColumn("INDEX");
        GradeData.addColumn("SCORE");
        TDisplayData2.setBounds(20,120,345,250);
        TDisplayData2.getColumnModel().getColumn(0).setPreferredWidth(10);
        TDisplayData2.setVisible(true);
        TDisplayData2.setVisible(false);
        JScrollPane ScrollP = new JScrollPane();
        //FINAL UI
        FRMGradingSystem.add(LBLHeader);
        FRMGradingSystem.add(LBLSubHeader);
        FRMGradingSystem.add(LBLChooseMode);
        FRMGradingSystem.add(btexit);
        FRMGradingSystem.add(btmode1);
        FRMGradingSystem.add(btmode2);
        FRMGradingSystem.setVisible(true);
        FRMGradingSystem.add(LBLHomework);
        FRMGradingSystem.add(LBLLaboratory);
        FRMGradingSystem.add(LBLExamination);
        FRMGradingSystem.add(tfpercent1);
        FRMGradingSystem.add(tfpercent2);
        FRMGradingSystem.add(tfpercent3);
        FRMGradingSystem.add(tfinput1A);
        FRMGradingSystem.add(tfinput1B);
        FRMGradingSystem.add(btadd1);
        FRMGradingSystem.add(LBLFinalCourseGrade1);
        FRMGradingSystem.add(LBLFinalCourseGrade2);
        FRMGradingSystem.add(btcancel);
        FRMGradingSystem.add(btremove1);
        FRMGradingSystem.add(btconfirm);
        FRMGradingSystem.add(CBTaskType);
        FRMGradingSystem.add(LBLSelectedMode1);
        FRMGradingSystem.add(LBLGradedScore);
        FRMGradingSystem.add(LBLTotalScore);
        FRMGradingSystem.add(LBLTaskType);
        FRMGradingSystem.add(TDisplayData1);
        FRMGradingSystem.add(ScrollP);
        FRMGradingSystem.add(tfinput2);
        FRMGradingSystem.add(btadd2);
        FRMGradingSystem.add(btremove2);
        FRMGradingSystem.add(TDisplayData2);
        FRMGradingSystem.add(LBLSelectedMode2);
        FRMGradingSystem.add(LBLGrade);
        FRMGradingSystem.add(LBLFinalGradeText);
        FRMGradingSystem.add(LBLFinalGradeResult);
        FRMGradingSystem.add(LBLAnalysis);
        FRMGradingSystem.add(LBLDescriptiveRating);
        FRMGradingSystem.add(LBLAcademicAward);
        FRMGradingSystem.add(LBLAward2A);
        FRMGradingSystem.add(LBLDistinctionAward);
        FRMGradingSystem.add(LBLAward2B);
        FRMGradingSystem.add(LBLLowestGradeText);
        FRMGradingSystem.add(LBLLowestGrade);
        FRMWarning.add(LBLWarning);
        FRMWarning.add(btok);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btmode1){
            Counter = 0;
            tfinput1A.setText("");
            tfinput1B.setText("");
            FRMGradingSystem.setSize(400,600);
            LBLSelectedMode1.setText("COURSE AVERAGE");
            LBLHeader.setVisible(false);
            LBLSubHeader.setVisible(false);
            btmode1.setVisible(false);
            btmode2.setVisible(false);
            LBLChooseMode.setVisible(false);
            btcancel.setVisible(true);
            LBLFinalCourseGrade1.setVisible(true);
            LBLFinalCourseGrade2.setVisible(true);
            btexit.setBounds(290,525,80,20);
            LBLHomework.setVisible(true);
            LBLLaboratory.setVisible(true);
            LBLExamination.setVisible(true);
            btconfirm.setVisible(true);
            tfpercent1.setVisible(true);
            tfpercent2.setVisible(true);
            tfpercent3.setVisible(true);
            btadd1.setVisible(true);
            btremove1.setVisible(true);
            CBTaskType.setVisible(true);
            LBLSelectedMode1.setVisible(true);
            LBLGradedScore.setVisible(true);
            LBLTotalScore.setVisible(true);
            LBLTaskType.setVisible(true);
            TDisplayData1.setVisible(true);
            tfinput1A.setVisible(true);
            tfinput1B.setVisible(true);
            
        }
        else if (e.getSource()==btmode2){
            Counter = 0;
            tfinput2.setText("");
            FRMGradingSystem.setSize(400,600);
            LBLSelectedMode2.setText("OVERALL AVERAGE");
            LBLHeader.setVisible(false);
            LBLSubHeader.setVisible(false);
            btmode1.setVisible(false);
            btmode2.setVisible(false);
            LBLChooseMode.setVisible(false);
            btcancel.setVisible(true);
            btexit.setBounds(290,525,80,20);
            tfinput2.setVisible(true);
            btadd2.setVisible(true);
            btremove2.setVisible(true);
            TDisplayData2.setVisible(true);
            LBLSelectedMode2.setVisible(true);
            LBLGrade.setVisible(true);
            LBLFinalGradeText.setVisible(true);
            LBLFinalGradeResult.setVisible(false);
            LBLDescriptiveRating.setVisible(true);
            LBLAnalysis.setVisible(true);
            LBLAcademicAward.setVisible(true);
            LBLAward2A.setVisible(true);
            LBLDistinctionAward.setVisible(true);
            LBLAward2B.setVisible(true);
            LBLLowestGradeText.setVisible(true);
            LBLLowestGrade.setVisible(true);
        }
        else if (e.getSource()==btexit){
            System.exit(0);
        }
        else if (e.getSource()==btcancel){
            FRMGradingSystem.setSize(400,300);
            btexit.setBounds(290,225,80,20);
            LBLHeader.setVisible(true);
            LBLSubHeader.setVisible(true);
            btmode1.setVisible(true);
            btmode2.setVisible(true);
            LBLChooseMode.setVisible(true);
            btadd1.setVisible(false);
            LBLFinalCourseGrade1.setVisible(false);
            LBLFinalCourseGrade2.setVisible(false);
            btcancel.setVisible(false);
            btremove1.setVisible(false);
            CBTaskType.setVisible(false);
            LBLSelectedMode1.setVisible(false);
            LBLHomework.setVisible(false);
            LBLLaboratory.setVisible(false);
            LBLExamination.setVisible(false);
            tfpercent1.setVisible(false);
            tfpercent2.setVisible(false);
            tfpercent3.setVisible(false);
            LBLGradedScore.setVisible(false);
            LBLTotalScore.setVisible(false);
            LBLTaskType.setVisible(false);
            TDisplayData1.setVisible(false);
            tfinput1A.setVisible(false);
            tfinput1B.setVisible(false);
            tfinput2.setVisible(false);
            btadd2.setVisible(false);
            btconfirm.setVisible(false);
            btremove2.setVisible(false);
            TDisplayData2.setVisible(false);
            LBLSelectedMode2.setVisible(false);
            LBLGrade.setVisible(false);
            LBLFinalGradeText.setVisible(false);
            LBLFinalGradeResult.setVisible(false);
            LBLDescriptiveRating.setVisible(false);
            LBLAnalysis.setVisible(false);
            LBLAcademicAward.setVisible(false);
            LBLAward2A.setVisible(false);
            LBLDistinctionAward.setVisible(false);
            LBLAward2B.setVisible(false);
            LBLLowestGradeText.setVisible(false);
            LBLLowestGrade.setVisible(false);
        }
        else if(e.getSource()==btadd1){
            Input1A = tfinput1A.getText();
            Input1B = tfinput1B.getText();
            if (Input1A.matches("[0-9]+") && Input1B.matches("[0-9]+")){
                SelectedTaskType = CBTaskType.getSelectedIndex();
                if (SelectedTaskType == 0){
                    SetTaskType = "Homework";
                }
                else if (SelectedTaskType == 1) {
                    SetTaskType = "Laboratory";
                }
                else if (SelectedTaskType == 2) {
                    SetTaskType = "Examination";
                }
                ScoreData.insertRow(Counter, new Object[] {Counter+1,Input1A, Input1B, SetTaskType});
                Counter++;
                SubjectGradeCalculation();
                GradeInterpretation(); 
            }
            else if (Input1A.isEmpty() || Input1B.isEmpty() || Input1A.matches("") || Input1B.matches("")){
                LBLWarning.setText("Enter valid number!");
                FRMWarning.setVisible(true);
            }
            else {
                LBLWarning.setText("Enter valid number!");
                FRMWarning.setVisible(true);
            }
            
        }
        else if(e.getSource()==btadd2){
            Input2 = tfinput2.getText();
            if (Input2.matches("1.0") || Input2.matches("[1.25]+") || Input2.matches("[1.5]+") || Input2.matches("[1.75]+") || Input2.matches("[2.0]+") || Input2.matches("[2.25]+") || Input2.matches("[2.5]+") || Input2.matches("[2.75]+") || Input2.matches("[3.0]+") || Input2.matches("[5.0]+")){
            GradeData.insertRow(Counter, new Object[] {Counter+1,Input2});
            Counter++;
            CourseGradeCalculation();
            DescriptiveRating();
            AnalysisforAcademicAward();
            AnalysisforDistinction();
            }
            else {
            LBLWarning.setText("Enter valid number!");
            FRMWarning.setVisible(true);
            }
        }
        else if(e.getSource()==btremove1){
            if (Counter != 0){
                ScoreData.removeRow(Counter-1);
                Counter--;
                SubjectGradeCounter = 0;
                SubjectGradeCalculation();
                GradeInterpretation();
            }
            else{
                LBLWarning.setText("No more data to delete!");
                FRMWarning.setVisible(true);
            }
        }
        else if(e.getSource()==btremove2){
            if (Counter != 0){
                GradeData.removeRow(Counter-1);
                Counter--; 
                CourseGradeCounter = 0;
                TotalAccumulatedGrade = 0;
            }
            else{
                LBLWarning.setText("No more data to delete!");
                FRMWarning.setVisible(true);
                LBLLowestGrade.setVisible(false);
                LBLAnalysis.setVisible(false);
                LBLAward2A.setVisible(false);
                LBLAward2B.setVisible(false);
                LBLFinalGradeResult.setVisible(false);
            }
            CourseGradeCalculation();
            DescriptiveRating();
            AnalysisforAcademicAward();
            AnalysisforDistinction();
        }
        else if(e.getSource()==btok){
            FRMWarning.setVisible(false);
        }
        else if(e.getSource()==btconfirm){
            TotalPercentage = 0;
            Percentage1 = tfpercent1.getText();
            Percentage2 = tfpercent2.getText();
            Percentage3 = tfpercent3.getText();
            if (Percentage1.matches("[0-9]+") && Percentage2.matches("[0-9]+") && Percentage3.matches("[0-9]+")){
                SMCategoryMultiplier1 = Integer.parseInt(Percentage1);
                SMCategoryMultiplier2 = Integer.parseInt(Percentage2);
                SMCategoryMultiplier3 = Integer.parseInt(Percentage3);
                TotalPercentage = SMCategoryMultiplier1 + SMCategoryMultiplier2 + SMCategoryMultiplier3;
                if (TotalPercentage == 100){
                    LBLWarning.setText("Success!");
                    FRMWarning.setVisible(true);
                    SubjectGradeCalculation();
                }
                else {
                    SMCategoryMultiplier1 = 0;
                    SMCategoryMultiplier2 = 0;
                    SMCategoryMultiplier3 = 0;
                    LBLWarning.setText("Multipler must equate to 100!");
                    FRMWarning.setVisible(true);
                }
            }
            else if (TotalPercentage != 100 || Percentage1.isEmpty() || Percentage2.isEmpty() || Percentage3.isEmpty()){
                LBLWarning.setText("Input valid multipler!");
                FRMWarning.setVisible(true);
            }
        }
    }
    public void SubjectGradeCalculation(){
        SubjectGradeCounter = 0;
        FinalGrade = 0;
        TotalHomeworkGradedScore = 0;
        TotalHomeworkTotalScore = 0;
        TotalLaboratoryGradedScore = 0;
        TotalLaboratoryTotalScore = 0;
        TotalExaminationGradedScore = 0;
        TotalExaminationTotalScore = 0;
        Calculation1 = SMCategoryMultiplier1/100;
        Calculation2 = SMCategoryMultiplier2/100;
        Calculation3 = SMCategoryMultiplier3/100;
        while (SubjectGradeCounter != Counter){
            SetTaskType = "" + ScoreData.getValueAt(SubjectGradeCounter,3);
            if (SetTaskType.matches("Homework")){
                SelectedTaskType = 1;
            }
            else if (SetTaskType.matches("Laboratory")){
                SelectedTaskType = 2;
            }
            else if (SetTaskType.matches("Examination")){
                SelectedTaskType = 3;
            }
            Input1A = "" + ScoreData.getValueAt(SubjectGradeCounter,1);
            CMInput1 = Double.parseDouble(Input1A);
            Input1B = "" + ScoreData.getValueAt(SubjectGradeCounter,2);
            CMInput2 = Double.parseDouble(Input1B);
            SubjectGradeCounter++;
            if (SelectedTaskType == 1){
                TotalHomeworkGradedScore = TotalHomeworkGradedScore + CMInput1;
                TotalHomeworkTotalScore = TotalHomeworkTotalScore + CMInput2;
            }
            else if (SelectedTaskType ==2){
                TotalLaboratoryGradedScore = TotalLaboratoryGradedScore + CMInput1;
                TotalLaboratoryTotalScore = TotalLaboratoryTotalScore + CMInput2;
            }
            else if (SelectedTaskType == 3) {
                TotalExaminationGradedScore = TotalExaminationGradedScore + CMInput1;
                TotalExaminationTotalScore = TotalExaminationTotalScore + CMInput2;
            }
            else {
                System.out.println("ERROR");
            }
                System.out.println("CMInput1: " + CMInput1);
                System.out.println("Input1A: " + Input1A);
                System.out.println("CMInput2: " + CMInput2);
                System.out.println("Input1B: " + Input1B);
                System.out.println("TASKTYPE: " + SetTaskType);
                System.out.println("HW: " + TotalHomeworkGradedScore);
                System.out.println("THW: " + TotalHomeworkTotalScore);
                System.out.println("L: " + TotalLaboratoryGradedScore);
                System.out.println("TL: " + TotalLaboratoryTotalScore);
                System.out.println("E: "+ TotalExaminationGradedScore);
                System.out.println("TE: " + TotalExaminationTotalScore);
        }
        FinalGrade = ((((TotalHomeworkGradedScore/TotalHomeworkTotalScore)*100)*Calculation1)+(((TotalLaboratoryGradedScore/TotalLaboratoryTotalScore)*100)*Calculation2)+(((TotalExaminationGradedScore/TotalExaminationTotalScore)*100)*Calculation3));
        if (TotalHomeworkTotalScore !=0 && TotalLaboratoryTotalScore !=0 && TotalExaminationTotalScore !=0){
            if (TotalPercentage != 100){
                LBLWarning.setText("ERROR: No set multiplier!");
                FRMWarning.setVisible(true);
            }
            else {
                GradeInterpretation();
                LBLFinalCourseGrade2.setText(TwoDecimal.format(FinalGrade) + " / " + CollegeGrade);
                LBLFinalGradeResult.setVisible(true);
            }
                
        }
        else {
            LBLFinalCourseGrade2.setText("Incomplete Input");
        }
    }
    public void CourseGradeCalculation(){
        CourseGradeCounter = 0;
        TotalAccumulatedGrade = 0;
        LowestGrade = 0;
        while (CourseGradeCounter != Counter){
            AcquiredGradeData = ""+GradeData.getValueAt(CourseGradeCounter, 1);
            NumericalAcquiredGradeData = Double.parseDouble(AcquiredGradeData);
            TotalAccumulatedGrade = TotalAccumulatedGrade+NumericalAcquiredGradeData;
            CourseGradeCounter++;
            FinalGrade = (TotalAccumulatedGrade/Counter);
            TwoDecimal.format(FinalGrade);
            if (LowestGrade == 0){
                LowestGrade = NumericalAcquiredGradeData;
            }
            else if (NumericalAcquiredGradeData > LowestGrade){
                LowestGrade = NumericalAcquiredGradeData;
            }
        }
        if (CourseGradeCounter != 0){
            SuccessfulCalculation = true;
            LBLLowestGrade.setVisible(true);
            LBLAnalysis.setVisible(true);
            LBLAward2A.setVisible(true);
            LBLAward2B.setVisible(true);
            LBLFinalGradeResult.setVisible(true);
        }
        else if (CourseGradeCounter <= 0){
            SuccessfulCalculation = false;
            LBLWarning.setText("No data!");
            FRMWarning.setVisible(true);
            LBLLowestGrade.setVisible(false);
            LBLAnalysis.setVisible(false);
            LBLAward2A.setVisible(false);
            LBLAward2B.setVisible(false);
            LBLFinalGradeResult.setVisible(false);
        }
        if (SuccessfulCalculation == true){
            CollegeGrade = FinalGrade;
            LBLFinalGradeResult.setText(TwoDecimal.format(FinalGrade));
        }
    }
    public void GradeInterpretation(){
        if (FinalGrade >= 98){
            CollegeGrade = 1;
        }
        else if(FinalGrade < 98 && FinalGrade >= 95){
            CollegeGrade = 1.25;   
        }
        else if(FinalGrade < 95 && FinalGrade >= 92){
            CollegeGrade = 1.5;
        }
        else if(FinalGrade < 92 && FinalGrade >= 89){
            CollegeGrade = 1.75;
        }
        else if(FinalGrade < 89 && FinalGrade >= 86){
            CollegeGrade = 2;
        }        
        else if(FinalGrade < 86 && FinalGrade >= 83){
            CollegeGrade = 2.25;
        }               
        else if(FinalGrade < 83 && FinalGrade >= 80){
            CollegeGrade = 2.5;
        }  
        else if(FinalGrade < 80 && FinalGrade >= 77){
            CollegeGrade = 2.75;
        }  
        else if(FinalGrade < 77 && FinalGrade >= 75){
            CollegeGrade = 3;
        }
        else {
            CollegeGrade = 5;
        }
    }
    public void DescriptiveRating(){
        if (CollegeGrade >= 1 && CollegeGrade <= 1.25) {
            LBLAnalysis.setText("Excellent/Very Superior");
        }
        else if (CollegeGrade >= 1.25 && CollegeGrade <1.5) {
            LBLAnalysis.setText("Superior");
        }
        else if (CollegeGrade >= 1.5 && CollegeGrade <= 2) {
            LBLAnalysis.setText("Very Good/Above Average");
        }
        else if (CollegeGrade >= 2 && CollegeGrade <= 2.5) {
            LBLAnalysis.setText("Good/Average");
        }
        else if (CollegeGrade >= 2.5 && CollegeGrade <= 3) {
            LBLAnalysis.setText("Satisfactory/Fair!");
        }
        else if (CollegeGrade >= 3) {
            LBLAnalysis.setText("Failure");
        }        
        else {
            LBLAnalysis.setText("Code execution fail at Average Mode output");
        }  
    }
    public void AnalysisforAcademicAward(){
        LBLLowestGrade.setText(String.valueOf(LowestGrade));
        if (FinalGrade >= 1 && FinalGrade <= 1.2 && LowestGrade <= 1.5){
            LBLAward2A.setText("Summa Cum Laude");
        }
        else if (FinalGrade >= 1.21 && FinalGrade <= 1.45 && LowestGrade <= 1.75){
            LBLAward2A.setText("Magna Cum Laude");
        } 
        else if (FinalGrade >= 1.46 && FinalGrade <= 1.75 && LowestGrade <= 2){
            LBLAward2A.setText("Cum Laude");
        }  
        else {
            LBLAward2A.setText("Not Eligible");
        }
    }
    public void AnalysisforDistinction(){
        if (FinalGrade >= 1 && FinalGrade <= 1.05 && LowestGrade <=1.5){
            LBLAward2B.setText("Academic Honors with Highest Distinction");
        }
        else if (FinalGrade >= 1.06 && FinalGrade <= 1.10 && LowestGrade <=1.5){
            LBLAward2B.setText("Academic Honors with High Distinction");
        } 
        else if (FinalGrade >= 1.11 && FinalGrade <= 1.15 && LowestGrade <=1.5){
            LBLAward2B.setText("Academic Honors with Distinction");
        }  
        else {
            LBLAward2B.setText("Not Eligible");
        }
    }
    public static void main(String[] args) {
        GradingSystem Initiator = new GradingSystem();
        Initiator.GradingSystem();
    }
}
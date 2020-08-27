
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MainFrame extends javax.swing.JFrame {
        
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement pst;
    public int count = 1;
    public int office = 0;
    public int home = 0;
    public int game = 0;
    public int gcard = 0;
    public int ups = 0;
    public int ss = 0;
    public double Minprice;
    public double Maxprice;
    public int select = 1;
    
    ArrayList<Cart> CF = new ArrayList<> ();
    
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        jProcessorTable.setRowHeight(56);
        jRAMTable.setRowHeight(56);
        jGCardTable.setRowHeight(56);
        jMotherboardTable.setRowHeight(56);
        jHardDiskTable.setRowHeight(56);
        jPowerSupplyTable.setRowHeight(56);
        jCasingTable.setRowHeight(56);
        jMonitorTable.setRowHeight(56);
        jKeyboardTable.setRowHeight (56);
        jMouseTable.setRowHeight (56);
        jSSTable.setRowHeight (56);
        jUPSTable.setRowHeight(56);
        jSearchTable.setRowHeight(56);
        showProcessorTable(); 
        showRAMTable(); 
        showGCardTable();
        showMotherboardTable();
        showHardDiskTable();
        showPowerSupplyTable();
        showCasingTable();
        showMonitorTable();
        showKeyboardTable();
        showMouseTable();
        showSoundSystemTable();
        showUPSTable();
        MinP1.setEnabled(false);
        ProcessorTextField.setEnabled(false);
        MotherboardTextField.setEnabled(false);
        RamTextField.setEnabled(false);
        HardDiskTextField.setEnabled(false);
        GraphicsCardTextField.setEnabled(false);
        PowerSupplyTextField.setEnabled(false);
        CasingTextField.setEnabled(false);
        MonitorTextField.setEnabled(false);
        KeyboardTextField.setEnabled(false);
        MouseTextField.setEnabled(false);
        SSTextField.setEnabled(false);
        UPSTextField.setEnabled(false);
        TotalPriceField.setEnabled(false);
    }
    
    public void DBConnect ()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database is Connecting.....");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_solutions", "root", "");
            System.out.println("Database is connected !");
            
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
    }
    
    public ArrayList<Processor> getProcessorTable()
    {
        ArrayList<Processor> Prolist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from processors";
            rs = st.executeQuery(query);
            Processor pro;
            while (rs.next())
            {
                pro = new Processor (rs.getInt("Processors_Id"), rs.getString("Model"), rs.getString("Code_Name"), rs.getDouble("Base_Frequency"), rs.getInt("Cache_Memory"), rs.getInt("Generation"), rs.getDouble("Price"), rs.getDouble("Rating"));
                Prolist.add(pro);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return Prolist;
    }
    
    public void showProcessorTable()
    {
        ArrayList<Processor> Pro = getProcessorTable();
        DefaultTableModel model = (DefaultTableModel) jProcessorTable.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i<Pro.size();i++)
        {
            row[0] = Pro.get(i).getId();
            row[1] = Pro.get(i).getModel();
            row[2] = Pro.get(i).getCodeName();
            row[3] = Pro.get(i).getBaseFrequency();
            row[4] = Pro.get(i).getCacheMemory();
            row[5] = Pro.get(i).getGeneration(); 
            row[6] = Pro.get(i).getPrice();
            row[7] = Pro.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<Motherboard> getMotherBoardTable()
    {
        ArrayList<Motherboard> MBlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from motherboard";
            rs = st.executeQuery(query);
            Motherboard mb;
            while (rs.next())
            {
                mb = new Motherboard (rs.getInt("MBoard_Id"), rs.getString("Model"), rs.getString("CPU_Sockets"), rs.getString("Chipset"), rs.getString("Supported_CPU"), rs.getString("Generation"), rs.getString("RAM_type"), rs.getString("RAM_bus"), rs.getInt("RAM_max"), rs.getString("PCI_Express"), rs.getDouble("Price"), rs.getDouble("Rating"));
                MBlist.add(mb);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return MBlist;
    }
    
    public void showMotherboardTable()
    {
        ArrayList<Motherboard> Mboard = getMotherBoardTable();
        DefaultTableModel model = (DefaultTableModel) jMotherboardTable.getModel();
        Object[] row = new Object[12];
        for (int i = 0; i<Mboard.size();i++)
        {
            row[0] = Mboard.get(i).getId();
            row[1] = Mboard.get(i).getModel();
            row[2] = Mboard.get(i).getCPUSocket();
            row[3] = Mboard.get(i).getChipset();
            row[4] = Mboard.get(i).getSupportedCPU();
            row[5] = Mboard.get(i).getGeneration();
            row[6] = Mboard.get(i).getRAMType();
            row[7] = Mboard.get(i).getRAMBus();
            row[8] = Mboard.get(i).getRAMMax();
            row[9] = Mboard.get(i).getPCIExpress();
            row[10] = Mboard.get(i).getPrice();
            row[11] = Mboard.get(i).getRating();
            
            
            
            model.addRow(row);
        }
    }
    
    public ArrayList<RAM> getRAMTable()
    {
        ArrayList<RAM> ramlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from ram";
            rs = st.executeQuery(query);
            RAM r;
            while (rs.next())
            {
                r = new RAM (rs.getInt("Ram_Id"), rs.getString("Model"), rs.getString("Memory_Type"), rs.getInt("Memory_Bus"), rs.getInt("Capacity"), rs.getDouble("Price"), rs.getDouble("Rating"));
                ramlist.add(r);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return ramlist;
    }
    
    public void showRAMTable()
    {
        ArrayList<RAM> ram = getRAMTable();
        DefaultTableModel model = (DefaultTableModel) jRAMTable.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i<ram.size();i++)
        {
            row[0] = ram.get(i).getId();
            row[1] = ram.get(i).getModel();
            row[2] = ram.get(i).getMemoryType();
            row[3] = ram.get(i).getMemoryBus();
            row[4] = ram.get(i).getCapacity();
            row[5] = ram.get(i).getPrice();
            row[6] = ram.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<GraphicsCard> getGCardTable()
    {
        ArrayList<GraphicsCard> GCardlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from graphicscard";
            rs = st.executeQuery(query);
            GraphicsCard gc;
            while (rs.next())
            {
                gc = new GraphicsCard (rs.getInt("GCard_Id"), rs.getString("Chipset"), rs.getString("Graphics_Engine_Model"), rs.getDouble("Interface_Bus"), rs.getInt("Memory"), rs.getInt("PSU"), rs.getDouble("Price"), rs.getDouble("Rating"));
                GCardlist.add(gc);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return GCardlist;
    }
    
    public void showGCardTable()
    {
        ArrayList<GraphicsCard> gcard = getGCardTable();
        DefaultTableModel model = (DefaultTableModel) jGCardTable.getModel();
        Object[] row = new Object[8];
        for (int i = 0; i<gcard.size();i++)
        {
            row[0] = gcard.get(i).getId();
            row[1] = gcard.get(i).getChipset();
            row[2] = gcard.get(i).getEngineModel();
            row[3] = gcard.get(i).getInterfaceBus();
            row[4] = gcard.get(i).getMemory();
            row[5] = gcard.get(i).getPSU(); 
            row[6] = gcard.get(i).getPrice();
            row[7] = gcard.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<HardDisk> getHardDiskTable()
    {
        ArrayList<HardDisk> HDlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from harddisk";
            rs = st.executeQuery(query);
            HardDisk hd;
            while (rs.next())
            {
                hd = new HardDisk (rs.getInt("Hdisk_Id"), rs.getString("Model"), rs.getDouble("Storage"), rs.getDouble("RPM"), rs.getDouble("Price"), rs.getDouble("Rating"));
                HDlist.add(hd);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return HDlist;
    }
    
    public void showHardDiskTable()
    {
        ArrayList<HardDisk> HD = getHardDiskTable();
        DefaultTableModel model = (DefaultTableModel) jHardDiskTable.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i<HD.size();i++)
        {
            row[0] = HD.get(i).getId();
            row[1] = HD.get(i).getModel();
            row[2] = HD.get(i).getStorage();
            row[3] = HD.get(i).getRPM();
            row[4] = HD.get(i).getPrice();
            row[5] = HD.get(i).getRating();
            model.addRow(row);
        }
    }
    
    
     public ArrayList<PowerSupply> getPowerSupplyTable()
    {
        ArrayList<PowerSupply> PSlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from powersupply";
            rs = st.executeQuery(query);
            PowerSupply ps;
            while (rs.next())
            {
                ps = new PowerSupply (rs.getInt("PSupply_Id"), rs.getString("Model"), rs.getInt("Maximum_Power"), rs.getDouble("Price"), rs.getDouble("Rating"));
                PSlist.add(ps);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return PSlist;
    }
    
    public void showPowerSupplyTable()
    {
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        DefaultTableModel model = (DefaultTableModel) jPowerSupplyTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i<PS.size();i++)
        {
            row[0] = PS.get(i).getId();
            row[1] = PS.get(i).getModel();
            row[2] = PS.get(i).getMaxPower();
            row[3] = PS.get(i).getPrice();
            row[4] = PS.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<Casing> getCasingTable()
    {
        ArrayList<Casing> Caselist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from casing";
            rs = st.executeQuery(query);
            Casing cas;
            while (rs.next())
            {
                cas = new Casing (rs.getBytes("Image"), rs.getInt("Casing_Id"), rs.getString("Model"), rs.getString("Supported_MotherBoard"), rs.getInt("PSU"), rs.getDouble("Price"), rs.getDouble("Rating"));
                Caselist.add(cas);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return Caselist;
    }
    
    public void showCasingTable() {
        ArrayList<Casing> c = getCasingTable();
        DefaultTableModel model = (DefaultTableModel) jCasingTable.getModel();
        Object[] row = new Object[6];
       
        for (int i = 0; i < c.size(); i++) 
        {
            row[0] = c.get(i).getId();
            row[1] = c.get(i).getModel();
            row[2] = c.get(i).getSupportedMotherboard();
            row[3] = c.get(i).getPSU();
            row[4] = c.get(i).getPrice();
            row[5] = c.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<Monitor> getMonitorTable()
    {
        ArrayList<Monitor> Monlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from monitor";
            rs = st.executeQuery(query);
            Monitor mon;
            while (rs.next())
            {
                mon = new Monitor (rs.getBytes("Image"), rs.getInt("Monitor_Id"), rs.getString("Model"), rs.getDouble("Display_size"), rs.getString("Display_Resolution"), rs.getDouble("Price"), rs.getDouble("Rating"));
                Monlist.add(mon);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return Monlist;
    }
    
    public void showMonitorTable() {
        ArrayList<Monitor> m = getMonitorTable();
        DefaultTableModel model = (DefaultTableModel) jMonitorTable.getModel();
        Object[] row = new Object[7];
       
        for (int i = 0; i < m.size(); i++) 
        {
            row[0] = m.get(i).getId();
            row[1] = m.get(i).getModel();
            row[2] = m.get(i).getDisplaySize();
            row[3] = m.get(i).getDisplayResolution();
            row[4] = m.get(i).getPrice();
            row[5] = m.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<Keyboard> getKeyboardTable()
    {
        ArrayList<Keyboard> keylist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from keyboard";
            rs = st.executeQuery(query);
            Keyboard key;
            while (rs.next())
            {
                key = new Keyboard (rs.getBytes("Image"), rs.getInt("K_Id"), rs.getString("Model"), rs.getString("Type"),  rs.getString("Connectivity"), rs.getDouble("Price"), rs.getDouble("Rating"));
                keylist.add(key);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return keylist;
    }
    
    public void showKeyboardTable() {
        ArrayList<Keyboard> k = getKeyboardTable();
        DefaultTableModel model = (DefaultTableModel) jKeyboardTable.getModel();
        Object[] row = new Object[6];
       
        for (int i = 0; i < k.size(); i++) 
        {
            row[0] = k.get(i).getId();
            row[1] = k.get(i).getModel();
            row[2] = k.get(i).getType();
            row[3] = k.get(i).getConnectivity();
            row[4] = k.get(i).getPrice();
            row[5] = k.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<Mouse> getMouseTable()
    {
        ArrayList<Mouse> Mouselist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from Mouse";
            rs = st.executeQuery(query);
            Mouse mou;
            while (rs.next())
            {
                mou = new Mouse (rs.getBytes("Image"), rs.getInt("Mouse_Id"), rs.getString("Model"), rs.getString("Type"),  rs.getString("Connectivity"), rs.getDouble("Price"), rs.getDouble("Rating"));
                Mouselist.add(mou);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return Mouselist;
    }
    
    public void showMouseTable() {
        ArrayList<Mouse> mo = getMouseTable();
        DefaultTableModel model = (DefaultTableModel) jMouseTable.getModel();
        Object[] row = new Object[6];
       
        for (int i = 0; i < mo.size(); i++) 
        {
            row[0] = mo.get(i).getId();
            row[1] = mo.get(i).getModel();
            row[2] = mo.get(i).getType();
            row[3] = mo.get(i).getConnectivity();
            row[4] = mo.get(i).getPrice();
            row[5] = mo.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<SoundSystem> getSoundSystemTable()
    {
        ArrayList<SoundSystem> SSlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from Soundsystem";
            rs = st.executeQuery(query);
            SoundSystem ss;
            while (rs.next())
            {
                ss = new SoundSystem (rs.getBytes("Image"), rs.getInt("SoundS_Id"), rs.getString("Brand"), rs.getString("Model"),  rs.getDouble("Channel"), rs.getDouble("Price"), rs.getDouble("Rating"));
                SSlist.add(ss);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return SSlist;
    }
    
    public void showSoundSystemTable() {
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        DefaultTableModel model = (DefaultTableModel) jSSTable.getModel();
        Object[] row = new Object[6];
       
        for (int i = 0; i < ss.size(); i++) 
        {
            row[0] = ss.get(i).getId();
            row[1] = ss.get(i).getModel();
            row[2] = ss.get(i).getChannel();
            row[3] = ss.get(i).getPrice();
            row[4] = ss.get(i).getRating();
            model.addRow(row);
        }
    }
    
    public ArrayList<UPS> getUPSTable()
    {
        ArrayList<UPS> UPSlist = new ArrayList<> ();
        
        try 
        {
            DBConnect();
            st = con.createStatement();
            String query = "Select * from ups";
            rs = st.executeQuery(query);
            UPS up;
            while (rs.next())
            {
                up = new UPS (rs.getBytes("Image"), rs.getInt("UPS_Id"), rs.getString("Model"), rs.getDouble("Price"), rs.getDouble("Rating"));
                UPSlist.add(up);
            }
        }catch (Exception ex){
            System.out.println("Error:" + ex);
        }
        
        return UPSlist;
    }
    
    public void showUPSTable() {
        ArrayList<UPS> up = getUPSTable();
        DefaultTableModel model = (DefaultTableModel) jUPSTable.getModel();
        Object[] row = new Object[6];
       
        for (int i = 0; i < up.size(); i++) 
        {
            row[0] = up.get(i).getId();
            row[1] = up.get(i).getModel();
            row[2] = up.get(i).getPrice();
            row[3] = up.get(i).getRating();
            model.addRow(row);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NamePanel = new javax.swing.JPanel();
        LogoNameLabel = new javax.swing.JLabel();
        TopSearchPanel = new javax.swing.JPanel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        CartButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ButtonScrollPane = new javax.swing.JScrollPane();
        ButtonPanel = new javax.swing.JPanel();
        ComponentsPanel = new javax.swing.JPanel();
        ProcessorButton = new javax.swing.JButton();
        MotherBoardButton = new javax.swing.JButton();
        HardDiskButton = new javax.swing.JButton();
        PowerSupplyButton = new javax.swing.JButton();
        CasingButton = new javax.swing.JButton();
        RamButton = new javax.swing.JButton();
        GraphicsCardButton = new javax.swing.JButton();
        ProcessorLogo = new javax.swing.JLabel();
        MotherBoardLabel = new javax.swing.JLabel();
        RAMLogo = new javax.swing.JLabel();
        GraphicsCardLogo = new javax.swing.JLabel();
        HardDiskLogo = new javax.swing.JLabel();
        PowerSupplyLogo = new javax.swing.JLabel();
        CasingLogo = new javax.swing.JLabel();
        MPanel = new javax.swing.JPanel();
        MonitorButton = new javax.swing.JButton();
        L1Label = new javax.swing.JLabel();
        KPanel = new javax.swing.JPanel();
        KeyboardButton = new javax.swing.JButton();
        L1Label1 = new javax.swing.JLabel();
        MoPanel = new javax.swing.JPanel();
        MouseButton = new javax.swing.JButton();
        L1Label2 = new javax.swing.JLabel();
        SSPanel = new javax.swing.JPanel();
        SSButton = new javax.swing.JButton();
        L1Label3 = new javax.swing.JLabel();
        UpsPanel = new javax.swing.JPanel();
        UpsButton = new javax.swing.JButton();
        L1Label4 = new javax.swing.JLabel();
        CPUComponentsPanel = new javax.swing.JPanel();
        CPU_ComponentLabel = new javax.swing.JLabel();
        ArrowLogoLabel = new javax.swing.JLabel();
        SPanel = new javax.swing.JPanel();
        SuggestionsButton = new javax.swing.JButton();
        CardMainPanel = new javax.swing.JPanel();
        MainLogoLabel = new javax.swing.JLabel();
        SuggestionsPanel = new javax.swing.JPanel();
        NameLogo1 = new javax.swing.JLabel();
        SuggestionShow1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Office1 = new javax.swing.JCheckBox();
        Home1 = new javax.swing.JCheckBox();
        Game1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        MinP1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        MaxP1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        GraphicsYes1 = new javax.swing.JCheckBox();
        GraphicsNo1 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        UPSYes1 = new javax.swing.JCheckBox();
        UPSNo1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        SSYes1 = new javax.swing.JCheckBox();
        SSNo1 = new javax.swing.JCheckBox();
        SugestionConfirm1 = new javax.swing.JButton();
        ProcessorPanel = new javax.swing.JPanel();
        NameLogo2 = new javax.swing.JLabel();
        ProcessorScrollPane = new javax.swing.JScrollPane();
        ProcessorPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jProcessorTable = new javax.swing.JTable();
        PCartRow1 = new javax.swing.JButton();
        PRateRow1 = new javax.swing.JButton();
        PCartRow2 = new javax.swing.JButton();
        PCartRow3 = new javax.swing.JButton();
        PCartRow4 = new javax.swing.JButton();
        PCartRow5 = new javax.swing.JButton();
        PCartRow6 = new javax.swing.JButton();
        PCartRow7 = new javax.swing.JButton();
        PCartRow8 = new javax.swing.JButton();
        PCartRow9 = new javax.swing.JButton();
        PCartRow10 = new javax.swing.JButton();
        PCartRow11 = new javax.swing.JButton();
        PCartRow12 = new javax.swing.JButton();
        PCartRow13 = new javax.swing.JButton();
        PCartRow14 = new javax.swing.JButton();
        PCartRow15 = new javax.swing.JButton();
        PCartRow16 = new javax.swing.JButton();
        PCartRow17 = new javax.swing.JButton();
        PCartRow18 = new javax.swing.JButton();
        PCartRow19 = new javax.swing.JButton();
        PCartRow20 = new javax.swing.JButton();
        PCartRow21 = new javax.swing.JButton();
        PCartRow22 = new javax.swing.JButton();
        PCartRow23 = new javax.swing.JButton();
        PCartRow24 = new javax.swing.JButton();
        PCartRow25 = new javax.swing.JButton();
        PCartRow26 = new javax.swing.JButton();
        PRateRow2 = new javax.swing.JButton();
        PRateRow3 = new javax.swing.JButton();
        PRateRow4 = new javax.swing.JButton();
        PRateRow5 = new javax.swing.JButton();
        PRateRow6 = new javax.swing.JButton();
        PRateRow7 = new javax.swing.JButton();
        PRateRow8 = new javax.swing.JButton();
        PRateRow9 = new javax.swing.JButton();
        PRateRow10 = new javax.swing.JButton();
        PRateRow11 = new javax.swing.JButton();
        PRateRow12 = new javax.swing.JButton();
        PRateRow13 = new javax.swing.JButton();
        PRateRow14 = new javax.swing.JButton();
        PRateRow15 = new javax.swing.JButton();
        PRateRow16 = new javax.swing.JButton();
        PRateRow17 = new javax.swing.JButton();
        PRateRow18 = new javax.swing.JButton();
        PRateRow19 = new javax.swing.JButton();
        PRateRow20 = new javax.swing.JButton();
        PRateRow21 = new javax.swing.JButton();
        PRateRow22 = new javax.swing.JButton();
        PRateRow23 = new javax.swing.JButton();
        PRateRow24 = new javax.swing.JButton();
        PRateRow25 = new javax.swing.JButton();
        PRateRow26 = new javax.swing.JButton();
        ProcessorRefesh = new javax.swing.JButton();
        MotherboardPanel = new javax.swing.JPanel();
        NameLogo3 = new javax.swing.JLabel();
        MBScrollPane1 = new javax.swing.JScrollPane();
        MotherboardPanel1 = new javax.swing.JPanel();
        MBCartRow1 = new javax.swing.JButton();
        MBRateRow1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jMotherboardTable = new javax.swing.JTable();
        MBCartRow2 = new javax.swing.JButton();
        MBRateRow2 = new javax.swing.JButton();
        MBCartRow3 = new javax.swing.JButton();
        MBRateRow3 = new javax.swing.JButton();
        MBCartRow4 = new javax.swing.JButton();
        MBRateRow4 = new javax.swing.JButton();
        MBCartRow5 = new javax.swing.JButton();
        MBRateRow5 = new javax.swing.JButton();
        MBCartRow6 = new javax.swing.JButton();
        MBRateRow6 = new javax.swing.JButton();
        MBCartRow7 = new javax.swing.JButton();
        MBRateRow7 = new javax.swing.JButton();
        MBCartRow8 = new javax.swing.JButton();
        MBRateRow8 = new javax.swing.JButton();
        MBCartRow9 = new javax.swing.JButton();
        MBRateRow9 = new javax.swing.JButton();
        MBCartRow10 = new javax.swing.JButton();
        MBRateRow10 = new javax.swing.JButton();
        MBCartRow11 = new javax.swing.JButton();
        MBRateRow11 = new javax.swing.JButton();
        ProcessorRefesh1 = new javax.swing.JButton();
        RamPanel = new javax.swing.JPanel();
        NameLogo4 = new javax.swing.JLabel();
        RAMScrollPane = new javax.swing.JScrollPane();
        RAMPanel1 = new javax.swing.JPanel();
        RamCartRow1 = new javax.swing.JButton();
        RAMRateRow1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jRAMTable = new javax.swing.JTable();
        RamCartRow2 = new javax.swing.JButton();
        RamCartRow3 = new javax.swing.JButton();
        RamCartRow4 = new javax.swing.JButton();
        RamCartRow5 = new javax.swing.JButton();
        RamCartRow6 = new javax.swing.JButton();
        RamCartRow7 = new javax.swing.JButton();
        RamCartRow8 = new javax.swing.JButton();
        RamCartRow9 = new javax.swing.JButton();
        RamCartRow10 = new javax.swing.JButton();
        RamCartRow11 = new javax.swing.JButton();
        RamCartRow12 = new javax.swing.JButton();
        RamCartRow13 = new javax.swing.JButton();
        RamCartRow14 = new javax.swing.JButton();
        RamCartRow15 = new javax.swing.JButton();
        RamCartRow16 = new javax.swing.JButton();
        RAMRateRow2 = new javax.swing.JButton();
        RAMRateRow3 = new javax.swing.JButton();
        RAMRateRow4 = new javax.swing.JButton();
        RAMRateRow5 = new javax.swing.JButton();
        RAMRateRow6 = new javax.swing.JButton();
        RAMRateRow7 = new javax.swing.JButton();
        RAMRateRow8 = new javax.swing.JButton();
        RAMRateRow9 = new javax.swing.JButton();
        RAMRateRow10 = new javax.swing.JButton();
        RAMRateRow11 = new javax.swing.JButton();
        RAMRateRow12 = new javax.swing.JButton();
        RAMRateRow13 = new javax.swing.JButton();
        RAMRateRow14 = new javax.swing.JButton();
        RAMRateRow15 = new javax.swing.JButton();
        RAMRateRow16 = new javax.swing.JButton();
        RAMRefesh = new javax.swing.JButton();
        GraphicsCardPanel = new javax.swing.JPanel();
        NameLogo5 = new javax.swing.JLabel();
        GCardScrollPane = new javax.swing.JScrollPane();
        GCardPanel1 = new javax.swing.JPanel();
        GCardCartRow1 = new javax.swing.JButton();
        GCardRateRow1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jGCardTable = new javax.swing.JTable();
        GCardCartRow2 = new javax.swing.JButton();
        GCardCartRow3 = new javax.swing.JButton();
        GCardCartRow4 = new javax.swing.JButton();
        GCardCartRow5 = new javax.swing.JButton();
        GCardCartRow6 = new javax.swing.JButton();
        GCardCartRow7 = new javax.swing.JButton();
        GCardCartRow8 = new javax.swing.JButton();
        GCardCartRow9 = new javax.swing.JButton();
        GCardCartRow10 = new javax.swing.JButton();
        GCardCartRow11 = new javax.swing.JButton();
        GCardCartRow12 = new javax.swing.JButton();
        GCardCartRow13 = new javax.swing.JButton();
        GCardCartRow14 = new javax.swing.JButton();
        GCardCartRow15 = new javax.swing.JButton();
        GCardCartRow16 = new javax.swing.JButton();
        GCardCartRow17 = new javax.swing.JButton();
        GCardCartRow18 = new javax.swing.JButton();
        GCardCartRow19 = new javax.swing.JButton();
        GCardCartRow20 = new javax.swing.JButton();
        GCardCartRow21 = new javax.swing.JButton();
        GCardCartRow22 = new javax.swing.JButton();
        GCardCartRow23 = new javax.swing.JButton();
        GCardRateRow2 = new javax.swing.JButton();
        GCardRateRow3 = new javax.swing.JButton();
        GCardRateRow4 = new javax.swing.JButton();
        GCardRateRow5 = new javax.swing.JButton();
        GCardRateRow6 = new javax.swing.JButton();
        GCardRateRow7 = new javax.swing.JButton();
        GCardRateRow8 = new javax.swing.JButton();
        GCardRateRow9 = new javax.swing.JButton();
        GCardRateRow10 = new javax.swing.JButton();
        GCardRateRow11 = new javax.swing.JButton();
        GCardRateRow12 = new javax.swing.JButton();
        GCardRateRow13 = new javax.swing.JButton();
        GCardRateRow14 = new javax.swing.JButton();
        GCardRateRow15 = new javax.swing.JButton();
        GCardRateRow16 = new javax.swing.JButton();
        GCardRateRow17 = new javax.swing.JButton();
        GCardRateRow18 = new javax.swing.JButton();
        GCardRateRow19 = new javax.swing.JButton();
        GCardRateRow20 = new javax.swing.JButton();
        GCardRateRow21 = new javax.swing.JButton();
        GCardRateRow22 = new javax.swing.JButton();
        GCardRateRow23 = new javax.swing.JButton();
        RAMRefesh1 = new javax.swing.JButton();
        InternalHDDPanel = new javax.swing.JPanel();
        NameLogo6 = new javax.swing.JLabel();
        HDRefresh = new javax.swing.JButton();
        HDScrollPane = new javax.swing.JScrollPane();
        HardDiskPanel1 = new javax.swing.JPanel();
        HDCartRow1 = new javax.swing.JButton();
        HDRateRow1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jHardDiskTable = new javax.swing.JTable();
        HDCartRow2 = new javax.swing.JButton();
        HDRateRow2 = new javax.swing.JButton();
        HDCartRow3 = new javax.swing.JButton();
        HDRateRow3 = new javax.swing.JButton();
        HDCartRow4 = new javax.swing.JButton();
        HDRateRow4 = new javax.swing.JButton();
        HDCartRow5 = new javax.swing.JButton();
        HDRateRow5 = new javax.swing.JButton();
        HDCartRow6 = new javax.swing.JButton();
        HDRateRow6 = new javax.swing.JButton();
        HDCartRow7 = new javax.swing.JButton();
        HDRateRow7 = new javax.swing.JButton();
        HDCartRow8 = new javax.swing.JButton();
        HDRateRow8 = new javax.swing.JButton();
        PowerSupplyPanel = new javax.swing.JPanel();
        NameLogo7 = new javax.swing.JLabel();
        PSRefresh = new javax.swing.JButton();
        PowerSupplyScrollPane = new javax.swing.JScrollPane();
        PowerSupplyPanel1 = new javax.swing.JPanel();
        PSCartRow1 = new javax.swing.JButton();
        PsRateRow1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPowerSupplyTable = new javax.swing.JTable();
        PSCartRow2 = new javax.swing.JButton();
        PsRateRow2 = new javax.swing.JButton();
        PSCartRow3 = new javax.swing.JButton();
        PsRateRow3 = new javax.swing.JButton();
        PSCartRow4 = new javax.swing.JButton();
        PsRateRow4 = new javax.swing.JButton();
        PSCartRow5 = new javax.swing.JButton();
        PsRateRow5 = new javax.swing.JButton();
        PSCartRow6 = new javax.swing.JButton();
        PsRateRow6 = new javax.swing.JButton();
        PSCartRow7 = new javax.swing.JButton();
        PsRateRow7 = new javax.swing.JButton();
        PSCartRow8 = new javax.swing.JButton();
        PsRateRow8 = new javax.swing.JButton();
        PSCartRow9 = new javax.swing.JButton();
        PsRateRow9 = new javax.swing.JButton();
        PSCartRow10 = new javax.swing.JButton();
        PsRateRow10 = new javax.swing.JButton();
        PSCartRow11 = new javax.swing.JButton();
        PsRateRow11 = new javax.swing.JButton();
        PSCartRow12 = new javax.swing.JButton();
        PsRateRow12 = new javax.swing.JButton();
        PSCartRow13 = new javax.swing.JButton();
        PsRateRow13 = new javax.swing.JButton();
        PSCartRow14 = new javax.swing.JButton();
        PsRateRow14 = new javax.swing.JButton();
        PSCartRow15 = new javax.swing.JButton();
        PsRateRow15 = new javax.swing.JButton();
        PSCartRow16 = new javax.swing.JButton();
        PsRateRow16 = new javax.swing.JButton();
        PSCartRow17 = new javax.swing.JButton();
        PsRateRow17 = new javax.swing.JButton();
        PSCartRow18 = new javax.swing.JButton();
        PsRateRow18 = new javax.swing.JButton();
        PSCartRow19 = new javax.swing.JButton();
        PsRateRow19 = new javax.swing.JButton();
        PSCartRow20 = new javax.swing.JButton();
        PsRateRow20 = new javax.swing.JButton();
        PSCartRow21 = new javax.swing.JButton();
        PsRateRow21 = new javax.swing.JButton();
        PSCartRow22 = new javax.swing.JButton();
        PsRateRow22 = new javax.swing.JButton();
        CasingPanel = new javax.swing.JPanel();
        NameLogo8 = new javax.swing.JLabel();
        CasingRefresh = new javax.swing.JButton();
        CasingScrollPane = new javax.swing.JScrollPane();
        CasingPane1 = new javax.swing.JPanel();
        CCartRow1 = new javax.swing.JButton();
        CRateRow1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jCasingTable = new javax.swing.JTable();
        CCartRow2 = new javax.swing.JButton();
        CRateRow2 = new javax.swing.JButton();
        CCartRow3 = new javax.swing.JButton();
        CRateRow3 = new javax.swing.JButton();
        CCartRow4 = new javax.swing.JButton();
        CRateRow4 = new javax.swing.JButton();
        CCartRow5 = new javax.swing.JButton();
        CRateRow5 = new javax.swing.JButton();
        CCartRow6 = new javax.swing.JButton();
        CRateRow6 = new javax.swing.JButton();
        CCartRow7 = new javax.swing.JButton();
        CRateRow7 = new javax.swing.JButton();
        CCartRow8 = new javax.swing.JButton();
        CRateRow8 = new javax.swing.JButton();
        CCartRow9 = new javax.swing.JButton();
        CRateRow9 = new javax.swing.JButton();
        CCartRow10 = new javax.swing.JButton();
        CRateRow10 = new javax.swing.JButton();
        MonitorPanel = new javax.swing.JPanel();
        NameLogo9 = new javax.swing.JLabel();
        MonitorRefresh = new javax.swing.JButton();
        MonitorScrollPane = new javax.swing.JScrollPane();
        MonitorPane1 = new javax.swing.JPanel();
        MonCartRow1 = new javax.swing.JButton();
        MonRateRow1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jMonitorTable = new javax.swing.JTable();
        MonCartRow2 = new javax.swing.JButton();
        MonRateRow2 = new javax.swing.JButton();
        MonCartRow3 = new javax.swing.JButton();
        MonRateRow3 = new javax.swing.JButton();
        MonCartRow4 = new javax.swing.JButton();
        MonRateRow4 = new javax.swing.JButton();
        MonCartRow5 = new javax.swing.JButton();
        MonRateRow5 = new javax.swing.JButton();
        MonCartRow6 = new javax.swing.JButton();
        MonRateRow6 = new javax.swing.JButton();
        MonCartRow7 = new javax.swing.JButton();
        MonRateRow7 = new javax.swing.JButton();
        MonCartRow8 = new javax.swing.JButton();
        MonRateRow8 = new javax.swing.JButton();
        MonCartRow9 = new javax.swing.JButton();
        MonRateRow9 = new javax.swing.JButton();
        MonCartRow10 = new javax.swing.JButton();
        MonRateRow10 = new javax.swing.JButton();
        MonCartRow11 = new javax.swing.JButton();
        MonRateRow11 = new javax.swing.JButton();
        MonRateRow12 = new javax.swing.JButton();
        MonCartRow12 = new javax.swing.JButton();
        MonRateRow13 = new javax.swing.JButton();
        MonCartRow13 = new javax.swing.JButton();
        MonRateRow14 = new javax.swing.JButton();
        MonCartRow14 = new javax.swing.JButton();
        MonRateRow15 = new javax.swing.JButton();
        MonCartRow15 = new javax.swing.JButton();
        MonRateRow16 = new javax.swing.JButton();
        MonCartRow16 = new javax.swing.JButton();
        MonRateRow17 = new javax.swing.JButton();
        MonCartRow17 = new javax.swing.JButton();
        KeyboardPanel = new javax.swing.JPanel();
        NameLogo10 = new javax.swing.JLabel();
        KeyboardRefresh = new javax.swing.JButton();
        KeyboardrScrollPane = new javax.swing.JScrollPane();
        KeyboardPane1 = new javax.swing.JPanel();
        keyCartRow1 = new javax.swing.JButton();
        keyRateRow1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jKeyboardTable = new javax.swing.JTable();
        keyCartRow2 = new javax.swing.JButton();
        keyRateRow2 = new javax.swing.JButton();
        keyCartRow3 = new javax.swing.JButton();
        keyRateRow3 = new javax.swing.JButton();
        keyCartRow4 = new javax.swing.JButton();
        keyRateRow4 = new javax.swing.JButton();
        keyCartRow5 = new javax.swing.JButton();
        keyRateRow5 = new javax.swing.JButton();
        keyCartRow6 = new javax.swing.JButton();
        keyRateRow6 = new javax.swing.JButton();
        keyCartRow7 = new javax.swing.JButton();
        keyRateRow7 = new javax.swing.JButton();
        keyCartRow8 = new javax.swing.JButton();
        keyRateRow8 = new javax.swing.JButton();
        keyCartRow9 = new javax.swing.JButton();
        keyRateRow9 = new javax.swing.JButton();
        MousePanel = new javax.swing.JPanel();
        NameLogo11 = new javax.swing.JLabel();
        KeyboardRefresh1 = new javax.swing.JButton();
        MouserScrollPane = new javax.swing.JScrollPane();
        MousePane1 = new javax.swing.JPanel();
        MouseCartRow1 = new javax.swing.JButton();
        MouseRateRow1 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jMouseTable = new javax.swing.JTable();
        MouseCartRow2 = new javax.swing.JButton();
        MouseRateRow2 = new javax.swing.JButton();
        MouseCartRow3 = new javax.swing.JButton();
        MouseRateRow3 = new javax.swing.JButton();
        MouseCartRow4 = new javax.swing.JButton();
        MouseRateRow4 = new javax.swing.JButton();
        MouseCartRow5 = new javax.swing.JButton();
        MouseRateRow5 = new javax.swing.JButton();
        MouseCartRow6 = new javax.swing.JButton();
        MouseRateRow6 = new javax.swing.JButton();
        MouseCartRow7 = new javax.swing.JButton();
        MouseRateRow7 = new javax.swing.JButton();
        MouseCartRow8 = new javax.swing.JButton();
        MouseRateRow8 = new javax.swing.JButton();
        MouseCartRow9 = new javax.swing.JButton();
        MouseRateRow9 = new javax.swing.JButton();
        MouseRateRow10 = new javax.swing.JButton();
        MouseCartRow10 = new javax.swing.JButton();
        MouseRateRow11 = new javax.swing.JButton();
        MouseCartRow11 = new javax.swing.JButton();
        MouseRateRow12 = new javax.swing.JButton();
        MouseCartRow12 = new javax.swing.JButton();
        MouseRateRow13 = new javax.swing.JButton();
        MouseCartRow13 = new javax.swing.JButton();
        SoundSystemPanel = new javax.swing.JPanel();
        NameLogo12 = new javax.swing.JLabel();
        SSRefresh = new javax.swing.JButton();
        SoundSystemScrollPane = new javax.swing.JScrollPane();
        SSPane1 = new javax.swing.JPanel();
        SSCartRow1 = new javax.swing.JButton();
        SSRateRow1 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jSSTable = new javax.swing.JTable();
        SSCartRow2 = new javax.swing.JButton();
        SSRateRow2 = new javax.swing.JButton();
        SSCartRow3 = new javax.swing.JButton();
        SSRateRow3 = new javax.swing.JButton();
        SSCartRow4 = new javax.swing.JButton();
        SSRateRow4 = new javax.swing.JButton();
        SSCartRow5 = new javax.swing.JButton();
        SSRateRow5 = new javax.swing.JButton();
        SSRow6 = new javax.swing.JButton();
        SSRateRow6 = new javax.swing.JButton();
        SSCartRow7 = new javax.swing.JButton();
        SSRateRow7 = new javax.swing.JButton();
        SSCartRow8 = new javax.swing.JButton();
        SSRateRow8 = new javax.swing.JButton();
        SSCartRow9 = new javax.swing.JButton();
        SSRateRow9 = new javax.swing.JButton();
        SSRateRow10 = new javax.swing.JButton();
        SSCartRow10 = new javax.swing.JButton();
        SSRateRow11 = new javax.swing.JButton();
        SSCartRow11 = new javax.swing.JButton();
        SSRateRow12 = new javax.swing.JButton();
        SSCartRow12 = new javax.swing.JButton();
        SSRateRow13 = new javax.swing.JButton();
        SSCartRow13 = new javax.swing.JButton();
        UPanel = new javax.swing.JPanel();
        NameLogo14 = new javax.swing.JLabel();
        UPSRefresh = new javax.swing.JButton();
        UPSScrollPane = new javax.swing.JScrollPane();
        UPSPane1 = new javax.swing.JPanel();
        UPSCartRow1 = new javax.swing.JButton();
        UPSRateRow1 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jUPSTable = new javax.swing.JTable();
        UPSCartRow2 = new javax.swing.JButton();
        UPSRateRow2 = new javax.swing.JButton();
        UPSCartRow3 = new javax.swing.JButton();
        UPSRateRow3 = new javax.swing.JButton();
        UPSCartRow4 = new javax.swing.JButton();
        UPSRateRow4 = new javax.swing.JButton();
        UPSCartRow5 = new javax.swing.JButton();
        UPSRateRow5 = new javax.swing.JButton();
        UPSCartRow6 = new javax.swing.JButton();
        UPSRateRow6 = new javax.swing.JButton();
        SearchPanel = new javax.swing.JPanel();
        NameLogo13 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jSearchTable = new javax.swing.JTable();
        SearchPanel2 = new javax.swing.JPanel();
        NameLogo15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SuggestionShow = new javax.swing.JPanel();
        NameLogo16 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        SuggestionScrollPane = new javax.swing.JScrollPane();
        SuggestionShowPane1 = new javax.swing.JPanel();
        ProcessorTextField = new javax.swing.JTextField();
        MotherboardTextField = new javax.swing.JTextField();
        RamTextField = new javax.swing.JTextField();
        GraphicsCardTextField = new javax.swing.JTextField();
        HardDiskTextField = new javax.swing.JTextField();
        PowerSupplyTextField = new javax.swing.JTextField();
        CasingTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        MonitorTextField = new javax.swing.JTextField();
        KeyboardTextField = new javax.swing.JTextField();
        MouseTextField = new javax.swing.JTextField();
        SSTextField = new javax.swing.JTextField();
        UPSTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        TotalPriceField = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1300, 725));

        NamePanel.setBackground(new java.awt.Color(137, 180, 177));
        NamePanel.setInheritsPopupMenu(true);
        NamePanel.setPreferredSize(new java.awt.Dimension(1380, 100));

        LogoNameLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        LogoNameLabel.setForeground(new java.awt.Color(51, 51, 51));
        LogoNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset 6.png"))); // NOI18N

        javax.swing.GroupLayout NamePanelLayout = new javax.swing.GroupLayout(NamePanel);
        NamePanel.setLayout(NamePanelLayout);
        NamePanelLayout.setHorizontalGroup(
            NamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        NamePanelLayout.setVerticalGroup(
            NamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TopSearchPanel.setBackground(new java.awt.Color(172, 172, 172));
        TopSearchPanel.setPreferredSize(new java.awt.Dimension(1380, 60));

        SearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextFieldActionPerformed(evt);
            }
        });
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyReleased(evt);
            }
        });

        SearchButton.setBackground(new java.awt.Color(137, 180, 177));
        SearchButton.setText("SEARCH");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        CartButton.setBackground(new java.awt.Color(137, 180, 177));
        CartButton.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        CartButton.setForeground(new java.awt.Color(51, 51, 51));
        CartButton.setText("View Cart");
        CartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cart.png"))); // NOI18N

        javax.swing.GroupLayout TopSearchPanelLayout = new javax.swing.GroupLayout(TopSearchPanel);
        TopSearchPanel.setLayout(TopSearchPanelLayout);
        TopSearchPanelLayout.setHorizontalGroup(
            TopSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopSearchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        TopSearchPanelLayout.setVerticalGroup(
            TopSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(TopSearchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(CartButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ButtonPanel.setBackground(new java.awt.Color(172, 172, 172));

        ComponentsPanel.setBackground(new java.awt.Color(137, 180, 177));

        ProcessorButton.setBackground(new java.awt.Color(137, 180, 177));
        ProcessorButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProcessorButton.setForeground(new java.awt.Color(51, 51, 51));
        ProcessorButton.setText("Processor");
        ProcessorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessorButtonActionPerformed(evt);
            }
        });

        MotherBoardButton.setBackground(new java.awt.Color(137, 180, 177));
        MotherBoardButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MotherBoardButton.setForeground(new java.awt.Color(51, 51, 51));
        MotherBoardButton.setText("MotherBoard\n\n");
        MotherBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotherBoardButtonActionPerformed(evt);
            }
        });

        HardDiskButton.setBackground(new java.awt.Color(137, 180, 177));
        HardDiskButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HardDiskButton.setForeground(new java.awt.Color(51, 51, 51));
        HardDiskButton.setText("Internal HDD");
        HardDiskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardDiskButtonActionPerformed(evt);
            }
        });

        PowerSupplyButton.setBackground(new java.awt.Color(137, 180, 177));
        PowerSupplyButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PowerSupplyButton.setForeground(new java.awt.Color(51, 51, 51));
        PowerSupplyButton.setText("Power Supply");
        PowerSupplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyButtonActionPerformed(evt);
            }
        });

        CasingButton.setBackground(new java.awt.Color(137, 180, 177));
        CasingButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CasingButton.setForeground(new java.awt.Color(51, 51, 51));
        CasingButton.setText("Casing");
        CasingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasingButtonActionPerformed(evt);
            }
        });

        RamButton.setBackground(new java.awt.Color(137, 180, 177));
        RamButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RamButton.setForeground(new java.awt.Color(51, 51, 51));
        RamButton.setText("RAM");
        RamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamButtonActionPerformed(evt);
            }
        });

        GraphicsCardButton.setBackground(new java.awt.Color(137, 180, 177));
        GraphicsCardButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GraphicsCardButton.setForeground(new java.awt.Color(51, 51, 51));
        GraphicsCardButton.setText("Graphics Card\n");
        GraphicsCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsCardButtonActionPerformed(evt);
            }
        });

        ProcessorLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Processor Logo.png"))); // NOI18N

        MotherBoardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MotherBoard Logo.png"))); // NOI18N

        RAMLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RAM Logo.png"))); // NOI18N

        GraphicsCardLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics Card Logo.png"))); // NOI18N

        HardDiskLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HDD Logo.png"))); // NOI18N

        PowerSupplyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Power Supply Logo.png"))); // NOI18N

        CasingLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Casing Logo.png"))); // NOI18N

        javax.swing.GroupLayout ComponentsPanelLayout = new javax.swing.GroupLayout(ComponentsPanel);
        ComponentsPanel.setLayout(ComponentsPanelLayout);
        ComponentsPanelLayout.setHorizontalGroup(
            ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComponentsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ProcessorLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MotherBoardLabel))
                    .addComponent(RAMLogo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GraphicsCardLogo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HardDiskLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PowerSupplyLogo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CasingLogo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CasingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProcessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GraphicsCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HardDiskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PowerSupplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MotherBoardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ComponentsPanelLayout.setVerticalGroup(
            ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComponentsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProcessorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProcessorLogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MotherBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MotherBoardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RAMLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GraphicsCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GraphicsCardLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HardDiskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HardDiskLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PowerSupplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PowerSupplyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CasingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CasingLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        MPanel.setBackground(new java.awt.Color(137, 180, 177));
        MPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MonitorButton.setBackground(new java.awt.Color(137, 180, 177));
        MonitorButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        MonitorButton.setForeground(new java.awt.Color(51, 51, 51));
        MonitorButton.setText("Monitor");
        MonitorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonitorButtonActionPerformed(evt);
            }
        });
        MPanel.add(MonitorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 220, 50));

        L1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Monitor Logo.png"))); // NOI18N
        MPanel.add(L1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        KPanel.setBackground(new java.awt.Color(137, 180, 177));

        KeyboardButton.setBackground(new java.awt.Color(137, 180, 177));
        KeyboardButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        KeyboardButton.setForeground(new java.awt.Color(51, 51, 51));
        KeyboardButton.setText("Keyboard");
        KeyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyboardButtonActionPerformed(evt);
            }
        });

        L1Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Keyboard Logo.png"))); // NOI18N

        javax.swing.GroupLayout KPanelLayout = new javax.swing.GroupLayout(KPanel);
        KPanel.setLayout(KPanelLayout);
        KPanelLayout.setHorizontalGroup(
            KPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        KPanelLayout.setVerticalGroup(
            KPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(KPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KeyboardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1Label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MoPanel.setBackground(new java.awt.Color(137, 180, 177));

        MouseButton.setBackground(new java.awt.Color(137, 180, 177));
        MouseButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        MouseButton.setForeground(new java.awt.Color(51, 51, 51));
        MouseButton.setText("Mouse");
        MouseButton.setBorderPainted(false);
        MouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseButtonActionPerformed(evt);
            }
        });

        L1Label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mouse Logo.png"))); // NOI18N

        javax.swing.GroupLayout MoPanelLayout = new javax.swing.GroupLayout(MoPanel);
        MoPanel.setLayout(MoPanelLayout);
        MoPanelLayout.setHorizontalGroup(
            MoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MoPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MoPanelLayout.setVerticalGroup(
            MoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(L1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        SSPanel.setBackground(new java.awt.Color(137, 180, 177));

        SSButton.setBackground(new java.awt.Color(137, 180, 177));
        SSButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        SSButton.setForeground(new java.awt.Color(51, 51, 51));
        SSButton.setText("Sound System");
        SSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSButtonActionPerformed(evt);
            }
        });

        L1Label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sound System Logo.png"))); // NOI18N

        javax.swing.GroupLayout SSPanelLayout = new javax.swing.GroupLayout(SSPanel);
        SSPanel.setLayout(SSPanelLayout);
        SSPanelLayout.setHorizontalGroup(
            SSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SSPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L1Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SSPanelLayout.setVerticalGroup(
            SSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(L1Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        UpsPanel.setBackground(new java.awt.Color(137, 180, 177));

        UpsButton.setBackground(new java.awt.Color(137, 180, 177));
        UpsButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        UpsButton.setForeground(new java.awt.Color(51, 51, 51));
        UpsButton.setText("UPS");
        UpsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpsButtonActionPerformed(evt);
            }
        });

        L1Label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UPS Logo.png"))); // NOI18N

        javax.swing.GroupLayout UpsPanelLayout = new javax.swing.GroupLayout(UpsPanel);
        UpsPanel.setLayout(UpsPanelLayout);
        UpsPanelLayout.setHorizontalGroup(
            UpsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(L1Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        UpsPanelLayout.setVerticalGroup(
            UpsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(L1Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        CPUComponentsPanel.setBackground(new java.awt.Color(137, 180, 177));

        CPU_ComponentLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        CPU_ComponentLabel.setForeground(new java.awt.Color(51, 51, 51));
        CPU_ComponentLabel.setText("CPU Components");

        ArrowLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ArrowIcon.png"))); // NOI18N

        javax.swing.GroupLayout CPUComponentsPanelLayout = new javax.swing.GroupLayout(CPUComponentsPanel);
        CPUComponentsPanel.setLayout(CPUComponentsPanelLayout);
        CPUComponentsPanelLayout.setHorizontalGroup(
            CPUComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPUComponentsPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(CPU_ComponentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArrowLogoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CPUComponentsPanelLayout.setVerticalGroup(
            CPUComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPUComponentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CPUComponentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CPU_ComponentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ArrowLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SPanel.setBackground(new java.awt.Color(137, 180, 177));

        SuggestionsButton.setBackground(new java.awt.Color(137, 180, 177));
        SuggestionsButton.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        SuggestionsButton.setForeground(new java.awt.Color(51, 51, 51));
        SuggestionsButton.setText("Suggestions");
        SuggestionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuggestionsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SPanelLayout = new javax.swing.GroupLayout(SPanel);
        SPanel.setLayout(SPanelLayout);
        SPanelLayout.setHorizontalGroup(
            SPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SuggestionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SPanelLayout.setVerticalGroup(
            SPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SPanelLayout.createSequentialGroup()
                .addComponent(SuggestionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ComponentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CPUComponentsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UpsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SSPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ButtonPanelLayout.setVerticalGroup(
            ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPUComponentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComponentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SSPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        ButtonScrollPane.setViewportView(ButtonPanel);

        CardMainPanel.setBackground(new java.awt.Color(195, 195, 195));
        CardMainPanel.setMinimumSize(new java.awt.Dimension(600, 530));
        CardMainPanel.setPreferredSize(new java.awt.Dimension(968, 520));
        CardMainPanel.setLayout(new java.awt.CardLayout());

        MainLogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset 5.png"))); // NOI18N
        CardMainPanel.add(MainLogoLabel, "card2");

        SuggestionsPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo1.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo1.setText("Suggestions");

        SuggestionShow1.setBackground(new java.awt.Color(172, 172, 172));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Price Range:");

        Office1.setBackground(new java.awt.Color(172, 172, 172));
        Office1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Office1.setForeground(new java.awt.Color(51, 51, 51));
        Office1.setText("Office PC");
        Office1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Office1ActionPerformed(evt);
            }
        });

        Home1.setBackground(new java.awt.Color(172, 172, 172));
        Home1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Home1.setForeground(new java.awt.Color(51, 51, 51));
        Home1.setText("Home PC");
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });

        Game1.setBackground(new java.awt.Color(172, 172, 172));
        Game1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Game1.setForeground(new java.awt.Color(51, 51, 51));
        Game1.setText("Gaming PC");
        Game1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Game1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Work Purpose:");

        MinP1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        MinP1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        MinP1.setText("25000.00");
        MinP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinP1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("-");

        MaxP1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        MaxP1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        MaxP1.setText("35000.00");
        MaxP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxP1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Do You Want a UPS?");

        GraphicsYes1.setBackground(new java.awt.Color(172, 172, 172));
        GraphicsYes1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        GraphicsYes1.setForeground(new java.awt.Color(51, 51, 51));
        GraphicsYes1.setText("Yes");
        GraphicsYes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsYes1ActionPerformed(evt);
            }
        });

        GraphicsNo1.setBackground(new java.awt.Color(172, 172, 172));
        GraphicsNo1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        GraphicsNo1.setForeground(new java.awt.Color(51, 51, 51));
        GraphicsNo1.setText("No");
        GraphicsNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsNo1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Do You Want a Graphics Card?");

        UPSYes1.setBackground(new java.awt.Color(172, 172, 172));
        UPSYes1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        UPSYes1.setForeground(new java.awt.Color(51, 51, 51));
        UPSYes1.setText("Yes");
        UPSYes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSYes1ActionPerformed(evt);
            }
        });

        UPSNo1.setBackground(new java.awt.Color(172, 172, 172));
        UPSNo1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        UPSNo1.setForeground(new java.awt.Color(51, 51, 51));
        UPSNo1.setText("No");
        UPSNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSNo1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Do You Want a Sound System?");

        SSYes1.setBackground(new java.awt.Color(172, 172, 172));
        SSYes1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        SSYes1.setForeground(new java.awt.Color(51, 51, 51));
        SSYes1.setText("Yes");
        SSYes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSYes1ActionPerformed(evt);
            }
        });

        SSNo1.setBackground(new java.awt.Color(172, 172, 172));
        SSNo1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        SSNo1.setForeground(new java.awt.Color(51, 51, 51));
        SSNo1.setText("No");
        SSNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSNo1ActionPerformed(evt);
            }
        });

        SugestionConfirm1.setBackground(new java.awt.Color(137, 180, 177));
        SugestionConfirm1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        SugestionConfirm1.setForeground(new java.awt.Color(51, 51, 51));
        SugestionConfirm1.setText("Confirm");
        SugestionConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SugestionConfirm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SuggestionShow1Layout = new javax.swing.GroupLayout(SuggestionShow1);
        SuggestionShow1.setLayout(SuggestionShow1Layout);
        SuggestionShow1Layout.setHorizontalGroup(
            SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionShow1Layout.createSequentialGroup()
                .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(Office1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(Game1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(MinP1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaxP1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(GraphicsYes1)
                        .addGap(100, 100, 100)
                        .addComponent(GraphicsNo1))
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SuggestionShow1Layout.createSequentialGroup()
                                .addComponent(UPSYes1)
                                .addGap(102, 102, 102)
                                .addComponent(UPSNo1))
                            .addGroup(SuggestionShow1Layout.createSequentialGroup()
                                .addComponent(SSYes1)
                                .addGap(100, 100, 100)
                                .addComponent(SSNo1))))
                    .addGroup(SuggestionShow1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(SugestionConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        SuggestionShow1Layout.setVerticalGroup(
            SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionShow1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Office1)
                    .addComponent(Home1)
                    .addComponent(Game1))
                .addGap(13, 13, 13)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MinP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaxP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GraphicsYes1)
                    .addComponent(GraphicsNo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UPSYes1)
                    .addComponent(UPSNo1))
                .addGap(1, 1, 1)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SuggestionShow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SSYes1)
                    .addComponent(SSNo1))
                .addGap(18, 18, 18)
                .addComponent(SugestionConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SuggestionsPanelLayout = new javax.swing.GroupLayout(SuggestionsPanel);
        SuggestionsPanel.setLayout(SuggestionsPanelLayout);
        SuggestionsPanelLayout.setHorizontalGroup(
            SuggestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionsPanelLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(NameLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuggestionsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SuggestionShow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SuggestionsPanelLayout.setVerticalGroup(
            SuggestionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionsPanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(NameLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SuggestionShow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CardMainPanel.add(SuggestionsPanel, "card16");

        ProcessorPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo2.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo2.setText("Processor");

        ProcessorScrollPane.setBackground(new java.awt.Color(172, 172, 172));

        ProcessorPanel1.setBackground(new java.awt.Color(172, 172, 172));

        jProcessorTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jProcessorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Code Name", "Base Frequency (GHz)", "Cache Memory (MB)", "Generation (th)", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jProcessorTable.setGridColor(new java.awt.Color(204, 204, 204));
        jProcessorTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jProcessorTable.getTableHeader().setResizingAllowed(false);
        jProcessorTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jProcessorTable);
        if (jProcessorTable.getColumnModel().getColumnCount() > 0) {
            jProcessorTable.getColumnModel().getColumn(0).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            jProcessorTable.getColumnModel().getColumn(1).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jProcessorTable.getColumnModel().getColumn(2).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(2).setPreferredWidth(120);
            jProcessorTable.getColumnModel().getColumn(3).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            jProcessorTable.getColumnModel().getColumn(4).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            jProcessorTable.getColumnModel().getColumn(5).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            jProcessorTable.getColumnModel().getColumn(6).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(7).setResizable(false);
            jProcessorTable.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        PCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow1ActionPerformed(evt);
            }
        });

        PRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow1ActionPerformed(evt);
            }
        });

        PCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow2ActionPerformed(evt);
            }
        });

        PCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow3ActionPerformed(evt);
            }
        });

        PCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow4ActionPerformed(evt);
            }
        });

        PCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow5ActionPerformed(evt);
            }
        });

        PCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow6ActionPerformed(evt);
            }
        });

        PCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow7ActionPerformed(evt);
            }
        });

        PCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow8ActionPerformed(evt);
            }
        });

        PCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow9ActionPerformed(evt);
            }
        });

        PCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow10ActionPerformed(evt);
            }
        });

        PCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow11ActionPerformed(evt);
            }
        });

        PCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow12ActionPerformed(evt);
            }
        });

        PCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow13ActionPerformed(evt);
            }
        });

        PCartRow14.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow14ActionPerformed(evt);
            }
        });

        PCartRow15.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow15ActionPerformed(evt);
            }
        });

        PCartRow16.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow16ActionPerformed(evt);
            }
        });

        PCartRow17.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow17ActionPerformed(evt);
            }
        });

        PCartRow18.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow18ActionPerformed(evt);
            }
        });

        PCartRow19.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow19ActionPerformed(evt);
            }
        });

        PCartRow20.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow20ActionPerformed(evt);
            }
        });

        PCartRow21.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow21ActionPerformed(evt);
            }
        });

        PCartRow22.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow22ActionPerformed(evt);
            }
        });

        PCartRow23.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow23ActionPerformed(evt);
            }
        });

        PCartRow24.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow24ActionPerformed(evt);
            }
        });

        PCartRow25.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow25ActionPerformed(evt);
            }
        });

        PCartRow26.setBackground(new java.awt.Color(137, 180, 177));
        PCartRow26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PCartRow26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCartRow26ActionPerformed(evt);
            }
        });

        PRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow2ActionPerformed(evt);
            }
        });

        PRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow3ActionPerformed(evt);
            }
        });

        PRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow4ActionPerformed(evt);
            }
        });

        PRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow5ActionPerformed(evt);
            }
        });

        PRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow6ActionPerformed(evt);
            }
        });

        PRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow7ActionPerformed(evt);
            }
        });

        PRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow8ActionPerformed(evt);
            }
        });

        PRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow9ActionPerformed(evt);
            }
        });

        PRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow10ActionPerformed(evt);
            }
        });

        PRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow11ActionPerformed(evt);
            }
        });

        PRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow12ActionPerformed(evt);
            }
        });

        PRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow13ActionPerformed(evt);
            }
        });

        PRateRow14.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow14ActionPerformed(evt);
            }
        });

        PRateRow15.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow15ActionPerformed(evt);
            }
        });

        PRateRow16.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow16ActionPerformed(evt);
            }
        });

        PRateRow17.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow17ActionPerformed(evt);
            }
        });

        PRateRow18.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow18ActionPerformed(evt);
            }
        });

        PRateRow19.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow19ActionPerformed(evt);
            }
        });

        PRateRow20.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow20ActionPerformed(evt);
            }
        });

        PRateRow21.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow21ActionPerformed(evt);
            }
        });

        PRateRow22.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow22ActionPerformed(evt);
            }
        });

        PRateRow23.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow23ActionPerformed(evt);
            }
        });

        PRateRow24.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow24ActionPerformed(evt);
            }
        });

        PRateRow25.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow25ActionPerformed(evt);
            }
        });

        PRateRow26.setBackground(new java.awt.Color(137, 180, 177));
        PRateRow26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PRateRow26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRateRow26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProcessorPanel1Layout = new javax.swing.GroupLayout(ProcessorPanel1);
        ProcessorPanel1.setLayout(ProcessorPanel1Layout);
        ProcessorPanel1Layout.setHorizontalGroup(
            ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcessorPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addComponent(PCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ProcessorPanel1Layout.setVerticalGroup(
            ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                    .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                            .addGroup(ProcessorPanel1Layout.createSequentialGroup()
                                                                                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                    .addComponent(PCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                    .addComponent(PRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                    .addComponent(PCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                    .addComponent(PRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                    .addComponent(PCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                    .addComponent(PRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(PCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                            .addComponent(PRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(PCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addComponent(PRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(PCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                            .addComponent(PRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(PCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addComponent(PRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(PCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addComponent(PRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(PCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(PRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(PCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(PRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(PCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(PRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(PCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(PRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(PCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(PRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(PCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(PRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(PCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(PRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(PRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PCartRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PRateRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PCartRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PRateRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PCartRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PRateRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PCartRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PRateRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PCartRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PRateRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PCartRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PRateRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCartRow24))
                    .addComponent(PRateRow24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCartRow25)
                    .addComponent(PRateRow25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProcessorPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PCartRow26)
                    .addComponent(PRateRow26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProcessorPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        ProcessorScrollPane.setViewportView(ProcessorPanel1);

        ProcessorRefesh.setBackground(new java.awt.Color(137, 180, 177));
        ProcessorRefesh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        ProcessorRefesh.setForeground(new java.awt.Color(51, 51, 51));
        ProcessorRefesh.setText("Refresh Table");
        ProcessorRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessorRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProcessorPanelLayout = new javax.swing.GroupLayout(ProcessorPanel);
        ProcessorPanel.setLayout(ProcessorPanelLayout);
        ProcessorPanelLayout.setHorizontalGroup(
            ProcessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcessorPanelLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(NameLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProcessorRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addComponent(ProcessorScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        ProcessorPanelLayout.setVerticalGroup(
            ProcessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcessorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProcessorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProcessorRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProcessorScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );

        CardMainPanel.add(ProcessorPanel, "card3");

        MotherboardPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo3.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo3.setText("MotherBoard");

        MBScrollPane1.setBackground(new java.awt.Color(172, 172, 172));
        MBScrollPane1.setForeground(new java.awt.Color(172, 172, 172));

        MotherboardPanel1.setBackground(new java.awt.Color(172, 172, 172));

        MBCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow1ActionPerformed(evt);
            }
        });

        MBRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow1ActionPerformed(evt);
            }
        });

        jMotherboardTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jMotherboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "CPU Sockets", "Chipset", "Supported CPU", "Generation Recommanded", "RAM Type Supported", "RAM Bus Supported", "RAM Max Capacity (GB)", "Interface Bus (PCI Express) Supported", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jMotherboardTable.setGridColor(new java.awt.Color(204, 204, 204));
        jMotherboardTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jMotherboardTable.getTableHeader().setResizingAllowed(false);
        jMotherboardTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jMotherboardTable);
        if (jMotherboardTable.getColumnModel().getColumnCount() > 0) {
            jMotherboardTable.getColumnModel().getColumn(0).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            jMotherboardTable.getColumnModel().getColumn(1).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(1).setPreferredWidth(250);
            jMotherboardTable.getColumnModel().getColumn(2).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            jMotherboardTable.getColumnModel().getColumn(3).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            jMotherboardTable.getColumnModel().getColumn(4).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(4).setPreferredWidth(520);
            jMotherboardTable.getColumnModel().getColumn(5).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(5).setPreferredWidth(120);
            jMotherboardTable.getColumnModel().getColumn(6).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            jMotherboardTable.getColumnModel().getColumn(7).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(7).setPreferredWidth(180);
            jMotherboardTable.getColumnModel().getColumn(8).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(8).setPreferredWidth(150);
            jMotherboardTable.getColumnModel().getColumn(9).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(9).setPreferredWidth(180);
            jMotherboardTable.getColumnModel().getColumn(10).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(10).setPreferredWidth(40);
            jMotherboardTable.getColumnModel().getColumn(11).setResizable(false);
            jMotherboardTable.getColumnModel().getColumn(11).setPreferredWidth(40);
        }

        MBCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow2ActionPerformed(evt);
            }
        });

        MBRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow2ActionPerformed(evt);
            }
        });

        MBCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow3ActionPerformed(evt);
            }
        });

        MBRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow3ActionPerformed(evt);
            }
        });

        MBCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow4ActionPerformed(evt);
            }
        });

        MBRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow4ActionPerformed(evt);
            }
        });

        MBCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow5ActionPerformed(evt);
            }
        });

        MBRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow5ActionPerformed(evt);
            }
        });

        MBCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow6ActionPerformed(evt);
            }
        });

        MBRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow6ActionPerformed(evt);
            }
        });

        MBCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow7ActionPerformed(evt);
            }
        });

        MBRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow7ActionPerformed(evt);
            }
        });

        MBCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow8ActionPerformed(evt);
            }
        });

        MBRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow8ActionPerformed(evt);
            }
        });

        MBCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow9ActionPerformed(evt);
            }
        });

        MBRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow9ActionPerformed(evt);
            }
        });

        MBCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow10ActionPerformed(evt);
            }
        });

        MBRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow10ActionPerformed(evt);
            }
        });

        MBCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        MBCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MBCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBCartRow11ActionPerformed(evt);
            }
        });

        MBRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        MBRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MBRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBRateRow11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MotherboardPanel1Layout = new javax.swing.GroupLayout(MotherboardPanel1);
        MotherboardPanel1.setLayout(MotherboardPanel1Layout);
        MotherboardPanel1Layout.setHorizontalGroup(
            MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 2600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MotherboardPanel1Layout.createSequentialGroup()
                        .addComponent(MBCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MBRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        MotherboardPanel1Layout.setVerticalGroup(
            MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MotherboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MBRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MBCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MotherboardPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        MBScrollPane1.setViewportView(MotherboardPanel1);

        ProcessorRefesh1.setBackground(new java.awt.Color(137, 180, 177));
        ProcessorRefesh1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        ProcessorRefesh1.setForeground(new java.awt.Color(51, 51, 51));
        ProcessorRefesh1.setText("Refresh Table");
        ProcessorRefesh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessorRefesh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MotherboardPanelLayout = new javax.swing.GroupLayout(MotherboardPanel);
        MotherboardPanel.setLayout(MotherboardPanelLayout);
        MotherboardPanelLayout.setHorizontalGroup(
            MotherboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MotherboardPanelLayout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(NameLogo3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(ProcessorRefesh1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addComponent(MBScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        MotherboardPanelLayout.setVerticalGroup(
            MotherboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MotherboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MotherboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo3)
                    .addComponent(ProcessorRefesh1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MBScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(MotherboardPanel, "card4");

        RamPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo4.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo4.setText("RAM");

        RAMScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        RAMScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        RAMPanel1.setBackground(new java.awt.Color(172, 172, 172));

        RamCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow1ActionPerformed(evt);
            }
        });

        RAMRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow1ActionPerformed(evt);
            }
        });

        jRAMTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jRAMTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Memory Type", "Memory Bus (MHz)", "Capacity (GB)", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jRAMTable.setGridColor(new java.awt.Color(204, 204, 204));
        jRAMTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jRAMTable.getTableHeader().setResizingAllowed(false);
        jRAMTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jRAMTable);
        if (jRAMTable.getColumnModel().getColumnCount() > 0) {
            jRAMTable.getColumnModel().getColumn(0).setResizable(false);
            jRAMTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            jRAMTable.getColumnModel().getColumn(1).setResizable(false);
            jRAMTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jRAMTable.getColumnModel().getColumn(2).setResizable(false);
            jRAMTable.getColumnModel().getColumn(3).setResizable(false);
            jRAMTable.getColumnModel().getColumn(4).setResizable(false);
            jRAMTable.getColumnModel().getColumn(5).setResizable(false);
            jRAMTable.getColumnModel().getColumn(6).setResizable(false);
        }

        RamCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow2ActionPerformed(evt);
            }
        });

        RamCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow3ActionPerformed(evt);
            }
        });

        RamCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow4ActionPerformed(evt);
            }
        });

        RamCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow5ActionPerformed(evt);
            }
        });

        RamCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow6ActionPerformed(evt);
            }
        });

        RamCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow7ActionPerformed(evt);
            }
        });

        RamCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow8ActionPerformed(evt);
            }
        });

        RamCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow9ActionPerformed(evt);
            }
        });

        RamCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow10ActionPerformed(evt);
            }
        });

        RamCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow11ActionPerformed(evt);
            }
        });

        RamCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow12ActionPerformed(evt);
            }
        });

        RamCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow13ActionPerformed(evt);
            }
        });

        RamCartRow14.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow14ActionPerformed(evt);
            }
        });

        RamCartRow15.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow15ActionPerformed(evt);
            }
        });

        RamCartRow16.setBackground(new java.awt.Color(137, 180, 177));
        RamCartRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        RamCartRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamCartRow16ActionPerformed(evt);
            }
        });

        RAMRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow2ActionPerformed(evt);
            }
        });

        RAMRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow3ActionPerformed(evt);
            }
        });

        RAMRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow4ActionPerformed(evt);
            }
        });

        RAMRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow5ActionPerformed(evt);
            }
        });

        RAMRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow6ActionPerformed(evt);
            }
        });

        RAMRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow7ActionPerformed(evt);
            }
        });

        RAMRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow8ActionPerformed(evt);
            }
        });

        RAMRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow9ActionPerformed(evt);
            }
        });

        RAMRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow10ActionPerformed(evt);
            }
        });

        RAMRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow11ActionPerformed(evt);
            }
        });

        RAMRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow12ActionPerformed(evt);
            }
        });

        RAMRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow13ActionPerformed(evt);
            }
        });

        RAMRateRow14.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow14ActionPerformed(evt);
            }
        });

        RAMRateRow15.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow15ActionPerformed(evt);
            }
        });

        RAMRateRow16.setBackground(new java.awt.Color(137, 180, 177));
        RAMRateRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        RAMRateRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRateRow16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RAMPanel1Layout = new javax.swing.GroupLayout(RAMPanel1);
        RAMPanel1.setLayout(RAMPanel1Layout);
        RAMPanel1Layout.setHorizontalGroup(
            RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RAMPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addComponent(RamCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RAMRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RAMPanel1Layout.setVerticalGroup(
            RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RAMPanel1Layout.createSequentialGroup()
                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(RAMPanel1Layout.createSequentialGroup()
                                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                                                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                            .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                                                                .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                                                                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                            .addComponent(RAMRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addComponent(RamCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                            .addComponent(RamCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addComponent(RAMRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(RamCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addComponent(RAMRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(RamCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                            .addComponent(RAMRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(RamCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(RAMRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(RamCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(RAMRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(RamCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addComponent(RAMRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(RamCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addComponent(RAMRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(RamCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(RAMRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(RamCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(RAMRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(RamCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(RAMRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(RamCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(RAMRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RamCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(RAMRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RamCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(RAMRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RamCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RAMRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RAMPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RamCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RAMRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RAMPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        RAMScrollPane.setViewportView(RAMPanel1);

        RAMRefesh.setBackground(new java.awt.Color(137, 180, 177));
        RAMRefesh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        RAMRefesh.setForeground(new java.awt.Color(51, 51, 51));
        RAMRefesh.setText("Refresh Table");
        RAMRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RamPanelLayout = new javax.swing.GroupLayout(RamPanel);
        RamPanel.setLayout(RamPanelLayout);
        RamPanelLayout.setHorizontalGroup(
            RamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RAMScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
            .addGroup(RamPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NameLogo4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252)
                .addComponent(RAMRefesh)
                .addGap(26, 26, 26))
        );
        RamPanelLayout.setVerticalGroup(
            RamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RAMRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RAMScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );

        CardMainPanel.add(RamPanel, "card5");

        GraphicsCardPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo5.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo5.setText("Graphics Card");

        GCardScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        GCardScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        GCardPanel1.setBackground(new java.awt.Color(172, 172, 172));

        GCardCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow1ActionPerformed(evt);
            }
        });

        GCardRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow1ActionPerformed(evt);
            }
        });

        jGCardTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jGCardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Chipset", "Graphics Engine Model", "Interface Bus (PCI Express)", "Memory (GB)", "PSU (W)", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jGCardTable.setGridColor(new java.awt.Color(204, 204, 204));
        jGCardTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jGCardTable.getTableHeader().setResizingAllowed(false);
        jGCardTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jGCardTable);
        if (jGCardTable.getColumnModel().getColumnCount() > 0) {
            jGCardTable.getColumnModel().getColumn(0).setResizable(false);
            jGCardTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            jGCardTable.getColumnModel().getColumn(1).setResizable(false);
            jGCardTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jGCardTable.getColumnModel().getColumn(2).setResizable(false);
            jGCardTable.getColumnModel().getColumn(2).setPreferredWidth(350);
            jGCardTable.getColumnModel().getColumn(3).setResizable(false);
            jGCardTable.getColumnModel().getColumn(3).setPreferredWidth(160);
            jGCardTable.getColumnModel().getColumn(4).setResizable(false);
            jGCardTable.getColumnModel().getColumn(4).setPreferredWidth(60);
            jGCardTable.getColumnModel().getColumn(5).setResizable(false);
            jGCardTable.getColumnModel().getColumn(5).setPreferredWidth(40);
            jGCardTable.getColumnModel().getColumn(6).setResizable(false);
            jGCardTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            jGCardTable.getColumnModel().getColumn(7).setResizable(false);
            jGCardTable.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        GCardCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow2ActionPerformed(evt);
            }
        });

        GCardCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow3ActionPerformed(evt);
            }
        });

        GCardCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow4ActionPerformed(evt);
            }
        });

        GCardCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow5ActionPerformed(evt);
            }
        });

        GCardCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow6ActionPerformed(evt);
            }
        });

        GCardCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow7ActionPerformed(evt);
            }
        });

        GCardCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow8ActionPerformed(evt);
            }
        });

        GCardCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow9ActionPerformed(evt);
            }
        });

        GCardCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow10ActionPerformed(evt);
            }
        });

        GCardCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow11ActionPerformed(evt);
            }
        });

        GCardCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow12ActionPerformed(evt);
            }
        });

        GCardCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow13ActionPerformed(evt);
            }
        });

        GCardCartRow14.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow14ActionPerformed(evt);
            }
        });

        GCardCartRow15.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow15ActionPerformed(evt);
            }
        });

        GCardCartRow16.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow16ActionPerformed(evt);
            }
        });

        GCardCartRow17.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow17ActionPerformed(evt);
            }
        });

        GCardCartRow18.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow18ActionPerformed(evt);
            }
        });

        GCardCartRow19.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow19ActionPerformed(evt);
            }
        });

        GCardCartRow20.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow20ActionPerformed(evt);
            }
        });

        GCardCartRow21.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow21ActionPerformed(evt);
            }
        });

        GCardCartRow22.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow22ActionPerformed(evt);
            }
        });

        GCardCartRow23.setBackground(new java.awt.Color(137, 180, 177));
        GCardCartRow23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        GCardCartRow23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardCartRow23ActionPerformed(evt);
            }
        });

        GCardRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow2ActionPerformed(evt);
            }
        });

        GCardRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow3ActionPerformed(evt);
            }
        });

        GCardRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow4ActionPerformed(evt);
            }
        });

        GCardRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow5ActionPerformed(evt);
            }
        });

        GCardRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow6ActionPerformed(evt);
            }
        });

        GCardRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow7ActionPerformed(evt);
            }
        });

        GCardRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow8ActionPerformed(evt);
            }
        });

        GCardRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow9ActionPerformed(evt);
            }
        });

        GCardRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow10ActionPerformed(evt);
            }
        });

        GCardRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow11ActionPerformed(evt);
            }
        });

        GCardRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow12ActionPerformed(evt);
            }
        });

        GCardRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow13ActionPerformed(evt);
            }
        });

        GCardRateRow14.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow14ActionPerformed(evt);
            }
        });

        GCardRateRow15.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow15ActionPerformed(evt);
            }
        });

        GCardRateRow16.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow16ActionPerformed(evt);
            }
        });

        GCardRateRow17.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow17ActionPerformed(evt);
            }
        });

        GCardRateRow18.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow18ActionPerformed(evt);
            }
        });

        GCardRateRow19.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow19ActionPerformed(evt);
            }
        });

        GCardRateRow20.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow20ActionPerformed(evt);
            }
        });

        GCardRateRow21.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow21ActionPerformed(evt);
            }
        });

        GCardRateRow22.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow22ActionPerformed(evt);
            }
        });

        GCardRateRow23.setBackground(new java.awt.Color(137, 180, 177));
        GCardRateRow23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        GCardRateRow23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCardRateRow23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GCardPanel1Layout = new javax.swing.GroupLayout(GCardPanel1);
        GCardPanel1.setLayout(GCardPanel1Layout);
        GCardPanel1Layout.setHorizontalGroup(
            GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GCardPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addComponent(GCardCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GCardRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );
        GCardPanel1Layout.setVerticalGroup(
            GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GCardPanel1Layout.createSequentialGroup()
                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                            .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                                                                                                                                                                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                            .addComponent(GCardRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                            .addComponent(GCardCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                        .addComponent(GCardCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                    .addComponent(GCardRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(GCardCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                            .addComponent(GCardRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                        .addComponent(GCardCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                    .addComponent(GCardRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(GCardCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                            .addComponent(GCardRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                        .addComponent(GCardCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                    .addComponent(GCardRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(GCardCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                            .addComponent(GCardRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                        .addComponent(GCardCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                    .addComponent(GCardRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(GCardCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                            .addComponent(GCardRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(GCardCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addComponent(GCardRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(GCardCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                            .addComponent(GCardRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(GCardCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addComponent(GCardRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(GCardCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addComponent(GCardRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(GCardCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(GCardRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(GCardCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(GCardRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(GCardCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(GCardRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(GCardCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(GCardRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(GCardCartRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(GCardRateRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(GCardCartRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(GCardRateRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(GCardCartRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(GCardRateRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(GCardCartRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(GCardRateRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GCardCartRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(GCardRateRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GCardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GCardCartRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GCardRateRow23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GCardPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        GCardScrollPane.setViewportView(GCardPanel1);

        RAMRefesh1.setBackground(new java.awt.Color(137, 180, 177));
        RAMRefesh1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        RAMRefesh1.setForeground(new java.awt.Color(51, 51, 51));
        RAMRefesh1.setText("Refresh Table");
        RAMRefesh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMRefesh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GraphicsCardPanelLayout = new javax.swing.GroupLayout(GraphicsCardPanel);
        GraphicsCardPanel.setLayout(GraphicsCardPanelLayout);
        GraphicsCardPanelLayout.setHorizontalGroup(
            GraphicsCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphicsCardPanelLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(NameLogo5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(RAMRefesh1)
                .addGap(25, 25, 25))
            .addComponent(GCardScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        GraphicsCardPanelLayout.setVerticalGroup(
            GraphicsCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphicsCardPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(GraphicsCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RAMRefesh1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLogo5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GCardScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        CardMainPanel.add(GraphicsCardPanel, "card6");

        InternalHDDPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo6.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo6.setText("Internal HDD");

        HDRefresh.setBackground(new java.awt.Color(137, 180, 177));
        HDRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        HDRefresh.setForeground(new java.awt.Color(51, 51, 51));
        HDRefresh.setText("Refresh Table");
        HDRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRefreshActionPerformed(evt);
            }
        });

        HDScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        HDScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        HardDiskPanel1.setBackground(new java.awt.Color(172, 172, 172));

        HDCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow1ActionPerformed(evt);
            }
        });

        HDRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow1ActionPerformed(evt);
            }
        });

        jHardDiskTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jHardDiskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Storage Capacity (TB)", "RPM", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jHardDiskTable.setGridColor(new java.awt.Color(204, 204, 204));
        jHardDiskTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jHardDiskTable.getTableHeader().setResizingAllowed(false);
        jHardDiskTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jHardDiskTable);
        if (jHardDiskTable.getColumnModel().getColumnCount() > 0) {
            jHardDiskTable.getColumnModel().getColumn(0).setResizable(false);
            jHardDiskTable.getColumnModel().getColumn(1).setResizable(false);
            jHardDiskTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jHardDiskTable.getColumnModel().getColumn(2).setResizable(false);
            jHardDiskTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            jHardDiskTable.getColumnModel().getColumn(3).setResizable(false);
            jHardDiskTable.getColumnModel().getColumn(4).setResizable(false);
            jHardDiskTable.getColumnModel().getColumn(5).setResizable(false);
        }

        HDCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow2ActionPerformed(evt);
            }
        });

        HDRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow2ActionPerformed(evt);
            }
        });

        HDCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow3ActionPerformed(evt);
            }
        });

        HDRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow3ActionPerformed(evt);
            }
        });

        HDCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow4ActionPerformed(evt);
            }
        });

        HDRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow4ActionPerformed(evt);
            }
        });

        HDCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow5ActionPerformed(evt);
            }
        });

        HDRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow5ActionPerformed(evt);
            }
        });

        HDCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow6ActionPerformed(evt);
            }
        });

        HDRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow6ActionPerformed(evt);
            }
        });

        HDCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow7ActionPerformed(evt);
            }
        });

        HDRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow7ActionPerformed(evt);
            }
        });

        HDCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        HDCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        HDCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDCartRow8ActionPerformed(evt);
            }
        });

        HDRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        HDRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        HDRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDRateRow8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HardDiskPanel1Layout = new javax.swing.GroupLayout(HardDiskPanel1);
        HardDiskPanel1.setLayout(HardDiskPanel1Layout);
        HardDiskPanel1Layout.setHorizontalGroup(
            HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                                        .addComponent(HDCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(HDRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HardDiskPanel1Layout.createSequentialGroup()
                                        .addComponent(HDCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(HDRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HardDiskPanel1Layout.createSequentialGroup()
                                    .addComponent(HDCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(HDRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HardDiskPanel1Layout.createSequentialGroup()
                                .addComponent(HDCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HDRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HardDiskPanel1Layout.createSequentialGroup()
                            .addComponent(HDCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(HDRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                        .addComponent(HDCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HDRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                        .addComponent(HDCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HDRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HardDiskPanel1Layout.createSequentialGroup()
                        .addComponent(HDCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HDRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        HardDiskPanel1Layout.setVerticalGroup(
            HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HardDiskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HDRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HDCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HardDiskPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        HDScrollPane.setViewportView(HardDiskPanel1);

        javax.swing.GroupLayout InternalHDDPanelLayout = new javax.swing.GroupLayout(InternalHDDPanel);
        InternalHDDPanel.setLayout(InternalHDDPanelLayout);
        InternalHDDPanelLayout.setHorizontalGroup(
            InternalHDDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InternalHDDPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NameLogo6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266)
                .addComponent(HDRefresh)
                .addGap(26, 26, 26))
            .addComponent(HDScrollPane)
        );
        InternalHDDPanelLayout.setVerticalGroup(
            InternalHDDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InternalHDDPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InternalHDDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo6)
                    .addComponent(HDRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HDScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(InternalHDDPanel, "card7");

        PowerSupplyPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo7.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo7.setText("Power Supply");

        PSRefresh.setBackground(new java.awt.Color(137, 180, 177));
        PSRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        PSRefresh.setForeground(new java.awt.Color(51, 51, 51));
        PSRefresh.setText("Refresh Table");
        PSRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSRefreshActionPerformed(evt);
            }
        });

        PowerSupplyScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        PowerSupplyScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        PowerSupplyPanel1.setBackground(new java.awt.Color(172, 172, 172));

        PSCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow1ActionPerformed(evt);
            }
        });

        PsRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow1ActionPerformed(evt);
            }
        });

        jPowerSupplyTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jPowerSupplyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Maximum Power (W)", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jPowerSupplyTable.setGridColor(new java.awt.Color(204, 204, 204));
        jPowerSupplyTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jPowerSupplyTable.getTableHeader().setResizingAllowed(false);
        jPowerSupplyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jPowerSupplyTable);
        if (jPowerSupplyTable.getColumnModel().getColumnCount() > 0) {
            jPowerSupplyTable.getColumnModel().getColumn(0).setResizable(false);
            jPowerSupplyTable.getColumnModel().getColumn(1).setResizable(false);
            jPowerSupplyTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jPowerSupplyTable.getColumnModel().getColumn(2).setResizable(false);
            jPowerSupplyTable.getColumnModel().getColumn(3).setResizable(false);
            jPowerSupplyTable.getColumnModel().getColumn(4).setResizable(false);
        }

        PSCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow2ActionPerformed(evt);
            }
        });

        PsRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow2ActionPerformed(evt);
            }
        });

        PSCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow3ActionPerformed(evt);
            }
        });

        PsRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow3ActionPerformed(evt);
            }
        });

        PSCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow4ActionPerformed(evt);
            }
        });

        PsRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow4ActionPerformed(evt);
            }
        });

        PSCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow5ActionPerformed(evt);
            }
        });

        PsRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow5ActionPerformed(evt);
            }
        });

        PSCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow6ActionPerformed(evt);
            }
        });

        PsRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow6ActionPerformed(evt);
            }
        });

        PSCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow7ActionPerformed(evt);
            }
        });

        PsRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow7ActionPerformed(evt);
            }
        });

        PSCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow8ActionPerformed(evt);
            }
        });

        PsRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow8ActionPerformed(evt);
            }
        });

        PSCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow9ActionPerformed(evt);
            }
        });

        PsRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow9ActionPerformed(evt);
            }
        });

        PSCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow10ActionPerformed(evt);
            }
        });

        PsRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow10ActionPerformed(evt);
            }
        });

        PSCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow11ActionPerformed(evt);
            }
        });

        PsRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow11ActionPerformed(evt);
            }
        });

        PSCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow12ActionPerformed(evt);
            }
        });

        PsRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow12ActionPerformed(evt);
            }
        });

        PSCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow13ActionPerformed(evt);
            }
        });

        PsRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow13ActionPerformed(evt);
            }
        });

        PSCartRow14.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow14ActionPerformed(evt);
            }
        });

        PsRateRow14.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow14ActionPerformed(evt);
            }
        });

        PSCartRow15.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow15ActionPerformed(evt);
            }
        });

        PsRateRow15.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow15ActionPerformed(evt);
            }
        });

        PSCartRow16.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow16ActionPerformed(evt);
            }
        });

        PsRateRow16.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow16ActionPerformed(evt);
            }
        });

        PSCartRow17.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow17ActionPerformed(evt);
            }
        });

        PsRateRow17.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow17ActionPerformed(evt);
            }
        });

        PSCartRow18.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow18ActionPerformed(evt);
            }
        });

        PsRateRow18.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow18ActionPerformed(evt);
            }
        });

        PSCartRow19.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow19ActionPerformed(evt);
            }
        });

        PsRateRow19.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow19ActionPerformed(evt);
            }
        });

        PSCartRow20.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow20ActionPerformed(evt);
            }
        });

        PsRateRow20.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow20ActionPerformed(evt);
            }
        });

        PSCartRow21.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow21ActionPerformed(evt);
            }
        });

        PsRateRow21.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow21ActionPerformed(evt);
            }
        });

        PSCartRow22.setBackground(new java.awt.Color(137, 180, 177));
        PSCartRow22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        PSCartRow22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSCartRow22ActionPerformed(evt);
            }
        });

        PsRateRow22.setBackground(new java.awt.Color(137, 180, 177));
        PsRateRow22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        PsRateRow22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsRateRow22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PowerSupplyPanel1Layout = new javax.swing.GroupLayout(PowerSupplyPanel1);
        PowerSupplyPanel1.setLayout(PowerSupplyPanel1Layout);
        PowerSupplyPanel1Layout.setHorizontalGroup(
            PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                    .addComponent(PSCartRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PsRateRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                                    .addComponent(PSCartRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PsRateRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PowerSupplyPanel1Layout.createSequentialGroup()
                                .addComponent(PSCartRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PsRateRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        PowerSupplyPanel1Layout.setVerticalGroup(
            PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PsRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PsRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PsRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PsRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PsRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSCartRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PsRateRow18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSCartRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PsRateRow19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSCartRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PsRateRow20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSCartRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PsRateRow21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PowerSupplyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSCartRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PsRateRow22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PowerSupplyPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        PowerSupplyScrollPane.setViewportView(PowerSupplyPanel1);

        javax.swing.GroupLayout PowerSupplyPanelLayout = new javax.swing.GroupLayout(PowerSupplyPanel);
        PowerSupplyPanel.setLayout(PowerSupplyPanelLayout);
        PowerSupplyPanelLayout.setHorizontalGroup(
            PowerSupplyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PowerSupplyPanelLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(NameLogo7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PSRefresh)
                .addGap(26, 26, 26))
            .addComponent(PowerSupplyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        PowerSupplyPanelLayout.setVerticalGroup(
            PowerSupplyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PowerSupplyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PowerSupplyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PSRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLogo7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PowerSupplyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(PowerSupplyPanel, "card8");

        CasingPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo8.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo8.setText("Casing");

        CasingRefresh.setBackground(new java.awt.Color(137, 180, 177));
        CasingRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        CasingRefresh.setForeground(new java.awt.Color(51, 51, 51));
        CasingRefresh.setText("Refresh Table");
        CasingRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasingRefreshActionPerformed(evt);
            }
        });

        CasingScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        CasingScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        CasingPane1.setBackground(new java.awt.Color(172, 172, 172));

        CCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow1ActionPerformed(evt);
            }
        });

        CRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow1ActionPerformed(evt);
            }
        });

        jCasingTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jCasingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Supported MotherBoard", "PSU", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jCasingTable.setGridColor(new java.awt.Color(204, 204, 204));
        jCasingTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jCasingTable.getTableHeader().setResizingAllowed(false);
        jCasingTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jCasingTable);
        if (jCasingTable.getColumnModel().getColumnCount() > 0) {
            jCasingTable.getColumnModel().getColumn(0).setResizable(false);
            jCasingTable.getColumnModel().getColumn(1).setResizable(false);
            jCasingTable.getColumnModel().getColumn(1).setPreferredWidth(250);
            jCasingTable.getColumnModel().getColumn(2).setResizable(false);
            jCasingTable.getColumnModel().getColumn(2).setPreferredWidth(250);
            jCasingTable.getColumnModel().getColumn(3).setResizable(false);
            jCasingTable.getColumnModel().getColumn(4).setResizable(false);
            jCasingTable.getColumnModel().getColumn(5).setResizable(false);
        }

        CCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow2ActionPerformed(evt);
            }
        });

        CRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow2ActionPerformed(evt);
            }
        });

        CCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow3ActionPerformed(evt);
            }
        });

        CRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow3ActionPerformed(evt);
            }
        });

        CCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow4ActionPerformed(evt);
            }
        });

        CRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow4ActionPerformed(evt);
            }
        });

        CCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow5ActionPerformed(evt);
            }
        });

        CRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow5ActionPerformed(evt);
            }
        });

        CCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow6ActionPerformed(evt);
            }
        });

        CRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow6ActionPerformed(evt);
            }
        });

        CCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow7ActionPerformed(evt);
            }
        });

        CRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow7ActionPerformed(evt);
            }
        });

        CCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow8ActionPerformed(evt);
            }
        });

        CRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow8ActionPerformed(evt);
            }
        });

        CCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow9ActionPerformed(evt);
            }
        });

        CRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow9ActionPerformed(evt);
            }
        });

        CCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        CCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        CCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCartRow10ActionPerformed(evt);
            }
        });

        CRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        CRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        CRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRateRow10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CasingPane1Layout = new javax.swing.GroupLayout(CasingPane1);
        CasingPane1.setLayout(CasingPane1Layout);
        CasingPane1Layout.setHorizontalGroup(
            CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CasingPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addComponent(CCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CasingPane1Layout.setVerticalGroup(
            CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CasingPane1Layout.createSequentialGroup()
                .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CasingPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CasingPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        CasingScrollPane.setViewportView(CasingPane1);

        javax.swing.GroupLayout CasingPanelLayout = new javax.swing.GroupLayout(CasingPanel);
        CasingPanel.setLayout(CasingPanelLayout);
        CasingPanelLayout.setHorizontalGroup(
            CasingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CasingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NameLogo8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260)
                .addComponent(CasingRefresh)
                .addGap(26, 26, 26))
            .addComponent(CasingScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        CasingPanelLayout.setVerticalGroup(
            CasingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CasingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CasingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo8)
                    .addComponent(CasingRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CasingScrollPane))
        );

        CardMainPanel.add(CasingPanel, "card9");

        MonitorPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo9.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo9.setText("Monitor");

        MonitorRefresh.setBackground(new java.awt.Color(137, 180, 177));
        MonitorRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        MonitorRefresh.setForeground(new java.awt.Color(51, 51, 51));
        MonitorRefresh.setText("Refresh Table");
        MonitorRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonitorRefreshActionPerformed(evt);
            }
        });

        MonitorScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        MonitorScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        MonitorPane1.setBackground(new java.awt.Color(172, 172, 172));

        MonCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow1ActionPerformed(evt);
            }
        });

        MonRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow1ActionPerformed(evt);
            }
        });

        jMonitorTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jMonitorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Display Size (Inch)", "Display Resolution", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jMonitorTable.setGridColor(new java.awt.Color(204, 204, 204));
        jMonitorTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jMonitorTable.getTableHeader().setResizingAllowed(false);
        jMonitorTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jMonitorTable);
        if (jMonitorTable.getColumnModel().getColumnCount() > 0) {
            jMonitorTable.getColumnModel().getColumn(0).setResizable(false);
            jMonitorTable.getColumnModel().getColumn(1).setResizable(false);
            jMonitorTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jMonitorTable.getColumnModel().getColumn(2).setResizable(false);
            jMonitorTable.getColumnModel().getColumn(3).setResizable(false);
            jMonitorTable.getColumnModel().getColumn(4).setResizable(false);
            jMonitorTable.getColumnModel().getColumn(5).setResizable(false);
        }

        MonCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow2ActionPerformed(evt);
            }
        });

        MonRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow2ActionPerformed(evt);
            }
        });

        MonCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow3ActionPerformed(evt);
            }
        });

        MonRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow3ActionPerformed(evt);
            }
        });

        MonCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow4ActionPerformed(evt);
            }
        });

        MonRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow4ActionPerformed(evt);
            }
        });

        MonCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow5ActionPerformed(evt);
            }
        });

        MonRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow5ActionPerformed(evt);
            }
        });

        MonCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow6ActionPerformed(evt);
            }
        });

        MonRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow6ActionPerformed(evt);
            }
        });

        MonCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow7ActionPerformed(evt);
            }
        });

        MonRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow7ActionPerformed(evt);
            }
        });

        MonCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow8ActionPerformed(evt);
            }
        });

        MonRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow8ActionPerformed(evt);
            }
        });

        MonCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow9ActionPerformed(evt);
            }
        });

        MonRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow9ActionPerformed(evt);
            }
        });

        MonCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow10ActionPerformed(evt);
            }
        });

        MonRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow10ActionPerformed(evt);
            }
        });

        MonCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow11ActionPerformed(evt);
            }
        });

        MonRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow11ActionPerformed(evt);
            }
        });

        MonRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow12ActionPerformed(evt);
            }
        });

        MonCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow12ActionPerformed(evt);
            }
        });

        MonRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow13ActionPerformed(evt);
            }
        });

        MonCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow13ActionPerformed(evt);
            }
        });

        MonRateRow14.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow14ActionPerformed(evt);
            }
        });

        MonCartRow14.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow14ActionPerformed(evt);
            }
        });

        MonRateRow15.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow15ActionPerformed(evt);
            }
        });

        MonCartRow15.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow15ActionPerformed(evt);
            }
        });

        MonRateRow16.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow16ActionPerformed(evt);
            }
        });

        MonCartRow16.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow16ActionPerformed(evt);
            }
        });

        MonRateRow17.setBackground(new java.awt.Color(137, 180, 177));
        MonRateRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MonRateRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonRateRow17ActionPerformed(evt);
            }
        });

        MonCartRow17.setBackground(new java.awt.Color(137, 180, 177));
        MonCartRow17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MonCartRow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonCartRow17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MonitorPane1Layout = new javax.swing.GroupLayout(MonitorPane1);
        MonitorPane1.setLayout(MonitorPane1Layout);
        MonitorPane1Layout.setHorizontalGroup(
            MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonitorPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addComponent(MonCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MonitorPane1Layout.setVerticalGroup(
            MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonitorPane1Layout.createSequentialGroup()
                .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MonitorPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonRateRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonCartRow17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MonitorPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        MonitorScrollPane.setViewportView(MonitorPane1);

        javax.swing.GroupLayout MonitorPanelLayout = new javax.swing.GroupLayout(MonitorPanel);
        MonitorPanel.setLayout(MonitorPanelLayout);
        MonitorPanelLayout.setHorizontalGroup(
            MonitorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonitorPanelLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(NameLogo9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MonitorRefresh)
                .addGap(26, 26, 26))
            .addComponent(MonitorScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        MonitorPanelLayout.setVerticalGroup(
            MonitorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MonitorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MonitorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo9)
                    .addComponent(MonitorRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MonitorScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(MonitorPanel, "card10");

        KeyboardPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo10.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo10.setText("KeyBoard");

        KeyboardRefresh.setBackground(new java.awt.Color(137, 180, 177));
        KeyboardRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        KeyboardRefresh.setForeground(new java.awt.Color(51, 51, 51));
        KeyboardRefresh.setText("Refresh Table");
        KeyboardRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyboardRefreshActionPerformed(evt);
            }
        });

        KeyboardrScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        KeyboardrScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        KeyboardPane1.setBackground(new java.awt.Color(172, 172, 172));

        keyCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow1ActionPerformed(evt);
            }
        });

        keyRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow1ActionPerformed(evt);
            }
        });

        jKeyboardTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jKeyboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Type", "Connectivity", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jKeyboardTable.setGridColor(new java.awt.Color(204, 204, 204));
        jKeyboardTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jKeyboardTable.getTableHeader().setResizingAllowed(false);
        jKeyboardTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jKeyboardTable);
        if (jKeyboardTable.getColumnModel().getColumnCount() > 0) {
            jKeyboardTable.getColumnModel().getColumn(0).setResizable(false);
            jKeyboardTable.getColumnModel().getColumn(1).setResizable(false);
            jKeyboardTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jKeyboardTable.getColumnModel().getColumn(2).setResizable(false);
            jKeyboardTable.getColumnModel().getColumn(2).setPreferredWidth(190);
            jKeyboardTable.getColumnModel().getColumn(3).setResizable(false);
            jKeyboardTable.getColumnModel().getColumn(4).setResizable(false);
            jKeyboardTable.getColumnModel().getColumn(5).setResizable(false);
        }

        keyCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow2ActionPerformed(evt);
            }
        });

        keyRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow2ActionPerformed(evt);
            }
        });

        keyCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow3ActionPerformed(evt);
            }
        });

        keyRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow3ActionPerformed(evt);
            }
        });

        keyCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow4ActionPerformed(evt);
            }
        });

        keyRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow4ActionPerformed(evt);
            }
        });

        keyCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow5ActionPerformed(evt);
            }
        });

        keyRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow5ActionPerformed(evt);
            }
        });

        keyCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow6ActionPerformed(evt);
            }
        });

        keyRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow6ActionPerformed(evt);
            }
        });

        keyCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow7ActionPerformed(evt);
            }
        });

        keyRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow7ActionPerformed(evt);
            }
        });

        keyCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow8ActionPerformed(evt);
            }
        });

        keyRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow8ActionPerformed(evt);
            }
        });

        keyCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        keyCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        keyCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyCartRow9ActionPerformed(evt);
            }
        });

        keyRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        keyRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        keyRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRateRow9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KeyboardPane1Layout = new javax.swing.GroupLayout(KeyboardPane1);
        KeyboardPane1.setLayout(KeyboardPane1Layout);
        KeyboardPane1Layout.setHorizontalGroup(
            KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KeyboardPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addComponent(keyCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KeyboardPane1Layout.setVerticalGroup(
            KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KeyboardPane1Layout.createSequentialGroup()
                .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(KeyboardPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(KeyboardPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        KeyboardrScrollPane.setViewportView(KeyboardPane1);

        javax.swing.GroupLayout KeyboardPanelLayout = new javax.swing.GroupLayout(KeyboardPanel);
        KeyboardPanel.setLayout(KeyboardPanelLayout);
        KeyboardPanelLayout.setHorizontalGroup(
            KeyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KeyboardPanelLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(NameLogo10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(KeyboardRefresh)
                .addGap(26, 26, 26))
            .addComponent(KeyboardrScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        KeyboardPanelLayout.setVerticalGroup(
            KeyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KeyboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KeyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo10)
                    .addComponent(KeyboardRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KeyboardrScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(KeyboardPanel, "card11");

        MousePanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo11.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo11.setText("Mouse");

        KeyboardRefresh1.setBackground(new java.awt.Color(137, 180, 177));
        KeyboardRefresh1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        KeyboardRefresh1.setForeground(new java.awt.Color(51, 51, 51));
        KeyboardRefresh1.setText("Refresh Table");
        KeyboardRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyboardRefresh1ActionPerformed(evt);
            }
        });

        MouserScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        MouserScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        MousePane1.setBackground(new java.awt.Color(172, 172, 172));

        MouseCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow1ActionPerformed(evt);
            }
        });

        MouseRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow1ActionPerformed(evt);
            }
        });

        jMouseTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jMouseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Type", "Connectivity", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jMouseTable.setGridColor(new java.awt.Color(204, 204, 204));
        jMouseTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jMouseTable.getTableHeader().setResizingAllowed(false);
        jMouseTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(jMouseTable);
        if (jMouseTable.getColumnModel().getColumnCount() > 0) {
            jMouseTable.getColumnModel().getColumn(0).setResizable(false);
            jMouseTable.getColumnModel().getColumn(1).setResizable(false);
            jMouseTable.getColumnModel().getColumn(1).setPreferredWidth(220);
            jMouseTable.getColumnModel().getColumn(2).setResizable(false);
            jMouseTable.getColumnModel().getColumn(3).setResizable(false);
            jMouseTable.getColumnModel().getColumn(4).setResizable(false);
            jMouseTable.getColumnModel().getColumn(5).setResizable(false);
        }

        MouseCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow2ActionPerformed(evt);
            }
        });

        MouseRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow2ActionPerformed(evt);
            }
        });

        MouseCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow3ActionPerformed(evt);
            }
        });

        MouseRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow3ActionPerformed(evt);
            }
        });

        MouseCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow4ActionPerformed(evt);
            }
        });

        MouseRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow4ActionPerformed(evt);
            }
        });

        MouseCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow5ActionPerformed(evt);
            }
        });

        MouseRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow5ActionPerformed(evt);
            }
        });

        MouseCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow6ActionPerformed(evt);
            }
        });

        MouseRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow6ActionPerformed(evt);
            }
        });

        MouseCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow7ActionPerformed(evt);
            }
        });

        MouseRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow7ActionPerformed(evt);
            }
        });

        MouseCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow8ActionPerformed(evt);
            }
        });

        MouseRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow8ActionPerformed(evt);
            }
        });

        MouseCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow9ActionPerformed(evt);
            }
        });

        MouseRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow9ActionPerformed(evt);
            }
        });

        MouseRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow10ActionPerformed(evt);
            }
        });

        MouseCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow10ActionPerformed(evt);
            }
        });

        MouseRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow11ActionPerformed(evt);
            }
        });

        MouseCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow11ActionPerformed(evt);
            }
        });

        MouseRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow12ActionPerformed(evt);
            }
        });

        MouseCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow12ActionPerformed(evt);
            }
        });

        MouseRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        MouseRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        MouseRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseRateRow13ActionPerformed(evt);
            }
        });

        MouseCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        MouseCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        MouseCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseCartRow13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MousePane1Layout = new javax.swing.GroupLayout(MousePane1);
        MousePane1.setLayout(MousePane1Layout);
        MousePane1Layout.setHorizontalGroup(
            MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MousePane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MousePane1Layout.createSequentialGroup()
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MousePane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MousePane1Layout.createSequentialGroup()
                                .addComponent(MouseCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MouseRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        MousePane1Layout.setVerticalGroup(
            MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MousePane1Layout.createSequentialGroup()
                .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MousePane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MousePane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MouseRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MousePane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        MouserScrollPane.setViewportView(MousePane1);

        javax.swing.GroupLayout MousePanelLayout = new javax.swing.GroupLayout(MousePanel);
        MousePanel.setLayout(MousePanelLayout);
        MousePanelLayout.setHorizontalGroup(
            MousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MousePanelLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(NameLogo11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(KeyboardRefresh1)
                .addGap(26, 26, 26))
            .addComponent(MouserScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        MousePanelLayout.setVerticalGroup(
            MousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KeyboardRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLogo11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MouserScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(MousePanel, "card12");

        SoundSystemPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo12.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo12.setText("Sound System");

        SSRefresh.setBackground(new java.awt.Color(137, 180, 177));
        SSRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        SSRefresh.setForeground(new java.awt.Color(51, 51, 51));
        SSRefresh.setText("Refresh Table");
        SSRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRefreshActionPerformed(evt);
            }
        });

        SoundSystemScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        SoundSystemScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        SSPane1.setBackground(new java.awt.Color(172, 172, 172));

        SSCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow1ActionPerformed(evt);
            }
        });

        SSRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow1ActionPerformed(evt);
            }
        });

        jSSTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jSSTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Channel", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jSSTable.setGridColor(new java.awt.Color(204, 204, 204));
        jSSTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jSSTable.getTableHeader().setResizingAllowed(false);
        jSSTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(jSSTable);
        if (jSSTable.getColumnModel().getColumnCount() > 0) {
            jSSTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        SSCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow2ActionPerformed(evt);
            }
        });

        SSRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow2ActionPerformed(evt);
            }
        });

        SSCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow3ActionPerformed(evt);
            }
        });

        SSRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow3ActionPerformed(evt);
            }
        });

        SSCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow4ActionPerformed(evt);
            }
        });

        SSRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow4ActionPerformed(evt);
            }
        });

        SSCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow5ActionPerformed(evt);
            }
        });

        SSRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow5ActionPerformed(evt);
            }
        });

        SSRow6.setBackground(new java.awt.Color(137, 180, 177));
        SSRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRow6ActionPerformed(evt);
            }
        });

        SSRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow6ActionPerformed(evt);
            }
        });

        SSCartRow7.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow7ActionPerformed(evt);
            }
        });

        SSRateRow7.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow7ActionPerformed(evt);
            }
        });

        SSCartRow8.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow8ActionPerformed(evt);
            }
        });

        SSRateRow8.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow8ActionPerformed(evt);
            }
        });

        SSCartRow9.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow9ActionPerformed(evt);
            }
        });

        SSRateRow9.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow9ActionPerformed(evt);
            }
        });

        SSRateRow10.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow10ActionPerformed(evt);
            }
        });

        SSCartRow10.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow10ActionPerformed(evt);
            }
        });

        SSRateRow11.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow11ActionPerformed(evt);
            }
        });

        SSCartRow11.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow11ActionPerformed(evt);
            }
        });

        SSRateRow12.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow12ActionPerformed(evt);
            }
        });

        SSCartRow12.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow12ActionPerformed(evt);
            }
        });

        SSRateRow13.setBackground(new java.awt.Color(137, 180, 177));
        SSRateRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        SSRateRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSRateRow13ActionPerformed(evt);
            }
        });

        SSCartRow13.setBackground(new java.awt.Color(137, 180, 177));
        SSCartRow13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        SSCartRow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCartRow13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SSPane1Layout = new javax.swing.GroupLayout(SSPane1);
        SSPane1.setLayout(SSPane1Layout);
        SSPane1Layout.setHorizontalGroup(
            SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SSPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SSPane1Layout.createSequentialGroup()
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(SSPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SSPane1Layout.createSequentialGroup()
                                .addComponent(SSCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SSRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        SSPane1Layout.setVerticalGroup(
            SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SSPane1Layout.createSequentialGroup()
                .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SSPane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SSRateRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSCartRow13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SSPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        SoundSystemScrollPane.setViewportView(SSPane1);

        javax.swing.GroupLayout SoundSystemPanelLayout = new javax.swing.GroupLayout(SoundSystemPanel);
        SoundSystemPanel.setLayout(SoundSystemPanelLayout);
        SoundSystemPanelLayout.setHorizontalGroup(
            SoundSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SoundSystemPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NameLogo12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219)
                .addComponent(SSRefresh)
                .addGap(26, 26, 26))
            .addComponent(SoundSystemScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        SoundSystemPanelLayout.setVerticalGroup(
            SoundSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SoundSystemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SoundSystemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLogo12)
                    .addComponent(SSRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SoundSystemScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
        );

        CardMainPanel.add(SoundSystemPanel, "card13");

        UPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo14.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo14.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo14.setText("UPS");

        UPSRefresh.setBackground(new java.awt.Color(137, 180, 177));
        UPSRefresh.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        UPSRefresh.setForeground(new java.awt.Color(51, 51, 51));
        UPSRefresh.setText("Refresh Table");
        UPSRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRefreshActionPerformed(evt);
            }
        });

        UPSScrollPane.setBackground(new java.awt.Color(172, 172, 172));
        UPSScrollPane.setForeground(new java.awt.Color(172, 172, 172));

        UPSPane1.setBackground(new java.awt.Color(172, 172, 172));

        UPSCartRow1.setBackground(new java.awt.Color(137, 180, 177));
        UPSCartRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        UPSCartRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSCartRow1ActionPerformed(evt);
            }
        });

        UPSRateRow1.setBackground(new java.awt.Color(137, 180, 177));
        UPSRateRow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        UPSRateRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRateRow1ActionPerformed(evt);
            }
        });

        jUPSTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jUPSTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Model", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jUPSTable.setGridColor(new java.awt.Color(204, 204, 204));
        jUPSTable.setSelectionBackground(new java.awt.Color(137, 180, 177));
        jUPSTable.getTableHeader().setResizingAllowed(false);
        jUPSTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(jUPSTable);

        UPSCartRow2.setBackground(new java.awt.Color(137, 180, 177));
        UPSCartRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        UPSCartRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSCartRow2ActionPerformed(evt);
            }
        });

        UPSRateRow2.setBackground(new java.awt.Color(137, 180, 177));
        UPSRateRow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        UPSRateRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRateRow2ActionPerformed(evt);
            }
        });

        UPSCartRow3.setBackground(new java.awt.Color(137, 180, 177));
        UPSCartRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        UPSCartRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSCartRow3ActionPerformed(evt);
            }
        });

        UPSRateRow3.setBackground(new java.awt.Color(137, 180, 177));
        UPSRateRow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        UPSRateRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRateRow3ActionPerformed(evt);
            }
        });

        UPSCartRow4.setBackground(new java.awt.Color(137, 180, 177));
        UPSCartRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        UPSCartRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSCartRow4ActionPerformed(evt);
            }
        });

        UPSRateRow4.setBackground(new java.awt.Color(137, 180, 177));
        UPSRateRow4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        UPSRateRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRateRow4ActionPerformed(evt);
            }
        });

        UPSCartRow5.setBackground(new java.awt.Color(137, 180, 177));
        UPSCartRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        UPSCartRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSCartRow5ActionPerformed(evt);
            }
        });

        UPSRateRow5.setBackground(new java.awt.Color(137, 180, 177));
        UPSRateRow5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        UPSRateRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRateRow5ActionPerformed(evt);
            }
        });

        UPSCartRow6.setBackground(new java.awt.Color(137, 180, 177));
        UPSCartRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SmallCart.png"))); // NOI18N
        UPSCartRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSCartRow6ActionPerformed(evt);
            }
        });

        UPSRateRow6.setBackground(new java.awt.Color(137, 180, 177));
        UPSRateRow6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Star.png"))); // NOI18N
        UPSRateRow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSRateRow6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPSPane1Layout = new javax.swing.GroupLayout(UPSPane1);
        UPSPane1.setLayout(UPSPane1Layout);
        UPSPane1Layout.setHorizontalGroup(
            UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPSPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addComponent(UPSCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addComponent(UPSCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addComponent(UPSCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addComponent(UPSCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addComponent(UPSCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addComponent(UPSCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        UPSPane1Layout.setVerticalGroup(
            UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPSPane1Layout.createSequentialGroup()
                .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UPSRateRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSCartRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UPSRateRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSCartRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UPSRateRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSCartRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UPSRateRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSCartRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UPSRateRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSCartRow5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UPSPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UPSRateRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSCartRow6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UPSPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        UPSScrollPane.setViewportView(UPSPane1);

        javax.swing.GroupLayout UPanelLayout = new javax.swing.GroupLayout(UPanel);
        UPanel.setLayout(UPanelLayout);
        UPanelLayout.setHorizontalGroup(
            UPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPanelLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(NameLogo14, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UPSRefresh)
                .addGap(26, 26, 26))
            .addComponent(UPSScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        UPanelLayout.setVerticalGroup(
            UPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UPSRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLogo14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPSScrollPane))
        );

        CardMainPanel.add(UPanel, "card14");

        SearchPanel.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo13.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo13.setText("Searches");

        jSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price (Tk)", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jSearchTable);
        if (jSearchTable.getColumnModel().getColumnCount() > 0) {
            jSearchTable.getColumnModel().getColumn(0).setResizable(false);
            jSearchTable.getColumnModel().getColumn(0).setPreferredWidth(600);
            jSearchTable.getColumnModel().getColumn(1).setResizable(false);
            jSearchTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            jSearchTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(NameLogo13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLogo13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        CardMainPanel.add(SearchPanel, "card15");

        SearchPanel2.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo15.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo15.setText("Searches");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("\"No Matches Found For The Searched Item\"");

        javax.swing.GroupLayout SearchPanel2Layout = new javax.swing.GroupLayout(SearchPanel2);
        SearchPanel2.setLayout(SearchPanel2Layout);
        SearchPanel2Layout.setHorizontalGroup(
            SearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanel2Layout.createSequentialGroup()
                .addGroup(SearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchPanel2Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(NameLogo15, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        SearchPanel2Layout.setVerticalGroup(
            SearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLogo15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        CardMainPanel.add(SearchPanel2, "card17");

        SuggestionShow.setBackground(new java.awt.Color(172, 172, 172));

        NameLogo16.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameLogo16.setForeground(new java.awt.Color(51, 51, 51));
        NameLogo16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLogo16.setText("Suggestions");

        BackButton.setBackground(new java.awt.Color(137, 180, 177));
        BackButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        BackButton.setForeground(new java.awt.Color(51, 51, 51));
        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        SuggestionScrollPane.setBackground(new java.awt.Color(172, 172, 172));

        SuggestionShowPane1.setBackground(new java.awt.Color(172, 172, 172));

        ProcessorTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        ProcessorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessorTextFieldActionPerformed(evt);
            }
        });

        MotherboardTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        MotherboardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotherboardTextFieldActionPerformed(evt);
            }
        });

        RamTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        RamTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamTextFieldActionPerformed(evt);
            }
        });

        GraphicsCardTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        GraphicsCardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsCardTextFieldActionPerformed(evt);
            }
        });

        HardDiskTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        HardDiskTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardDiskTextFieldActionPerformed(evt);
            }
        });

        PowerSupplyTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        PowerSupplyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyTextFieldActionPerformed(evt);
            }
        });

        CasingTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        CasingTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasingTextFieldActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(137, 180, 177));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CPU:");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Processor:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("MotherBoard:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("RAM:");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Graphics Card:");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Hard Disk:");

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Power Suply:");

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Casing:");

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Monitor:");

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Keyboard:");

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Mouse:");

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Sound System:");

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("UPS:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        MonitorTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        MonitorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonitorTextFieldActionPerformed(evt);
            }
        });

        KeyboardTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        KeyboardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyboardTextFieldActionPerformed(evt);
            }
        });

        MouseTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        MouseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MouseTextFieldActionPerformed(evt);
            }
        });

        SSTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        SSTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSTextFieldActionPerformed(evt);
            }
        });

        UPSTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        UPSTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPSTextFieldActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(137, 180, 177));

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Total Price:");

        TotalPriceField.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        TotalPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPriceFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TotalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SuggestionShowPane1Layout = new javax.swing.GroupLayout(SuggestionShowPane1);
        SuggestionShowPane1.setLayout(SuggestionShowPane1Layout);
        SuggestionShowPane1Layout.setHorizontalGroup(
            SuggestionShowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionShowPane1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(SuggestionShowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SuggestionShowPane1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SuggestionShowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProcessorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MotherboardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GraphicsCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HardDiskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PowerSupplyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CasingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonitorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KeyboardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UPSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        SuggestionShowPane1Layout.setVerticalGroup(
            SuggestionShowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionShowPane1Layout.createSequentialGroup()
                .addGroup(SuggestionShowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuggestionShowPane1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(ProcessorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MotherboardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraphicsCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HardDiskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PowerSupplyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CasingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(MonitorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KeyboardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UPSTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SuggestionShowPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        SuggestionScrollPane.setViewportView(SuggestionShowPane1);

        javax.swing.GroupLayout SuggestionShowLayout = new javax.swing.GroupLayout(SuggestionShow);
        SuggestionShow.setLayout(SuggestionShowLayout);
        SuggestionShowLayout.setHorizontalGroup(
            SuggestionShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionShowLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addComponent(NameLogo16, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(SuggestionScrollPane)
        );
        SuggestionShowLayout.setVerticalGroup(
            SuggestionShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuggestionShowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SuggestionShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLogo16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SuggestionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CardMainPanel.add(SuggestionShow, "card18");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CardMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(NamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addComponent(TopSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(NamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CardMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(ButtonScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextFieldActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
       
        
        if (SearchTextField.getText().equals("")) 
        {
            SearchFrameEmpty.main(null);
        } 
        
        else {

            try {
                String s = SearchTextField.getText();
                String sql1 = "SELECT model, price, rating from processors WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql2 = "SELECT model, price, rating from motherboard WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql3 = "SELECT model, price, rating from ram WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql4 = "SELECT model, price, rating from harddisk WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql5 = "SELECT model, price, rating from graphicscard WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql6 = "SELECT model, price, rating from powersupply WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql7 = "SELECT model, price, rating from casing WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql8 = "SELECT model, price, rating from monitor WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql9 = "SELECT model, price, rating from keyboard WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql10 = "SELECT model, price, rating from mouse WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql11 = "SELECT model, price, rating from soundsystem WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                String sql12 = "SELECT model, price, rating from ups WHERE model LIKE \"%" + SearchTextField.getText() + "%\"";
                
                
                pst = con.prepareStatement(sql1);
                //pst = con.prepareStatement(sql2);
                //pst = con.prepareStatement(sql3);
                //pst = con.prepareStatement(sql4);
                //pst = con.prepareStatement(sql5);
                //pst = con.prepareStatement(sql6);
                //pst = con.prepareStatement(sql7);
                //pst = con.prepareStatement(sql8);
                //pst = con.prepareStatement(sql9);
                //pst = con.prepareStatement(sql10);
                //pst = con.prepareStatement(sql11);
                //pst = con.prepareStatement(sql12);
                rs = pst.executeQuery();
                
                if (rs.next())
                {
                    CardMainPanel.removeAll();
                    CardMainPanel.add(SearchPanel);
                    CardMainPanel.repaint();
                    CardMainPanel.revalidate();

                    Object[] row = new Object[3];

                    while (rs.next()) {
                        row[0] = rs.getString("Model");
                        row[1] = rs.getDouble("Price");
                        row[2] = rs.getDouble("Rating");
                        model.addRow(row);
                    }
                    SearchTextField.setText(null);
                }
                
                else 
                {
                    CardMainPanel.removeAll();
                    CardMainPanel.add(SearchPanel2);
                    CardMainPanel.repaint();
                    CardMainPanel.revalidate();
                    SearchTextField.setText(null);
                } 
                
            } catch (Exception ex) {
                System.out.println("Error:" + ex);
            }
        }

    }//GEN-LAST:event_SearchButtonActionPerformed

    private void PowerSupplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(PowerSupplyPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getPowerSupplyTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
        
    }//GEN-LAST:event_PowerSupplyButtonActionPerformed

    private void CasingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasingButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(CasingPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getCasingTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_CasingButtonActionPerformed

    private void MonitorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonitorButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(MonitorPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_MonitorButtonActionPerformed

    private void SuggestionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuggestionsButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(SuggestionsPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_SuggestionsButtonActionPerformed

    private void ProcessorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessorButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(ProcessorPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getProcessorTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_ProcessorButtonActionPerformed

    private void MotherBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotherBoardButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(MotherboardPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getMotherBoardTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_MotherBoardButtonActionPerformed

    private void RamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(RamPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getRAMTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_RamButtonActionPerformed

    private void GraphicsCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsCardButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(GraphicsCardPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getGCardTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_GraphicsCardButtonActionPerformed

    private void HardDiskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardDiskButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(InternalHDDPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getHardDiskTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_HardDiskButtonActionPerformed

    private void KeyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyboardButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(KeyboardPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getKeyboardTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_KeyboardButtonActionPerformed

    private void MouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(MousePanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getMouseTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_MouseButtonActionPerformed

    private void SSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(SoundSystemPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getSoundSystemTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_SSButtonActionPerformed

    private void UpsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpsButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(UPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        getUPSTable();
        SearchTextField.setText(null);
        DefaultTableModel model = (DefaultTableModel) jSearchTable.getModel();
        model.setRowCount(0);
        //model.setRowCount(100);
    }//GEN-LAST:event_UpsButtonActionPerformed

    private void CartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartButtonActionPerformed
        CartFrame cart = new CartFrame (CF);
    }//GEN-LAST:event_CartButtonActionPerformed

    private void PCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow2ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(1).getModel();
        double price = Pro.get(1).getPrice();
        int id = Pro.get(0).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);                                       
    }//GEN-LAST:event_PCartRow2ActionPerformed

    private void PCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow13ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(12).getModel();
        double price = Pro.get(12).getPrice();
        int id = Pro.get(12).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow13ActionPerformed

    private void PRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow13ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(12).getRating(), query, q, 113);
    }//GEN-LAST:event_PRateRow13ActionPerformed

    private void PRateRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow14ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(13).getRating(), query, q, 114);
    }//GEN-LAST:event_PRateRow14ActionPerformed

    private void PRateRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow15ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(14).getRating(), query, q, 115);
    }//GEN-LAST:event_PRateRow15ActionPerformed

    private void PRateRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow16ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(15).getRating(), query, q, 116);
    }//GEN-LAST:event_PRateRow16ActionPerformed

    private void PRateRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow17ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(16).getRating(), query, q, 117);
    }//GEN-LAST:event_PRateRow17ActionPerformed

    private void PRateRow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow18ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(17).getRating(), query, q, 118);
    }//GEN-LAST:event_PRateRow18ActionPerformed

    private void PRateRow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow19ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(18).getRating(), query, q, 119);
    }//GEN-LAST:event_PRateRow19ActionPerformed

    private void PRateRow20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow20ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(19).getRating(), query, q, 120);
    }//GEN-LAST:event_PRateRow20ActionPerformed

    private void PRateRow21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow21ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(20).getRating(), query, q, 121);
    }//GEN-LAST:event_PRateRow21ActionPerformed

    private void PRateRow22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow22ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(21).getRating(), query, q, 122);
    }//GEN-LAST:event_PRateRow22ActionPerformed

    private void PRateRow23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow23ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(22).getRating(), query, q, 123);
    }//GEN-LAST:event_PRateRow23ActionPerformed

    private void PRateRow24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow24ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(23).getRating(), query, q, 124);
    }//GEN-LAST:event_PRateRow24ActionPerformed

    private void PRateRow25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow25ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(24).getRating(), query, q, 125);
    }//GEN-LAST:event_PRateRow25ActionPerformed

    private void PRateRow26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow26ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(25).getRating(), query, q, 126);
    }//GEN-LAST:event_PRateRow26ActionPerformed

    private void PCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow1ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(0).getModel();
        double price = Pro.get(0).getPrice();
        int id = Pro.get(0).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);       
    }//GEN-LAST:event_PCartRow1ActionPerformed

    private void PRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow1ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(0).getRating(), query, q, 101);
    }//GEN-LAST:event_PRateRow1ActionPerformed

    private void PCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow3ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(2).getModel();
        double price = Pro.get(2).getPrice();
        int id = Pro.get(2).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);                        
    }//GEN-LAST:event_PCartRow3ActionPerformed

    private void PCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow4ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(3).getModel();
        double price = Pro.get(3).getPrice();
        int id = Pro.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_PCartRow4ActionPerformed

    private void PCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow5ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(4).getModel();
        double price = Pro.get(4).getPrice();
        int id = Pro.get(4).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow5ActionPerformed

    private void PCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow6ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(5).getModel();
        double price = Pro.get(5).getPrice();
        int id = Pro.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_PCartRow6ActionPerformed

    private void PCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow7ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(6).getModel();
        double price = Pro.get(6).getPrice();
        int id = Pro.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_PCartRow7ActionPerformed

    private void PCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow8ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(7).getModel();
        double price = Pro.get(7).getPrice();
        int id = Pro.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);  
    }//GEN-LAST:event_PCartRow8ActionPerformed

    private void PCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow9ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(8).getModel();
        double price = Pro.get(8).getPrice();
        int id = Pro.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);  
    }//GEN-LAST:event_PCartRow9ActionPerformed

    private void PCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow10ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(9).getModel();
        double price = Pro.get(9).getPrice();
        int id = Pro.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_PCartRow10ActionPerformed

    private void PCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow11ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(10).getModel();
        double price = Pro.get(10).getPrice();
        int id = Pro.get(10).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow11ActionPerformed

    private void PCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow12ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(11).getModel();
        double price = Pro.get(11).getPrice();
        int id = Pro.get(11).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow12ActionPerformed

    private void PCartRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow14ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(13).getModel();
        double price = Pro.get(13).getPrice();
        int id = Pro.get(13).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow14ActionPerformed

    private void PCartRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow15ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(14).getModel();
        double price = Pro.get(14).getPrice();
        int id = Pro.get(14).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow15ActionPerformed

    private void PCartRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow16ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(15).getModel();
        double price = Pro.get(15).getPrice();
        int id = Pro.get(15).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow16ActionPerformed

    private void PCartRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow17ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(16).getModel();
        double price = Pro.get(16).getPrice();
        int id = Pro.get(16).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow17ActionPerformed

    private void PCartRow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow18ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(17).getModel();
        double price = Pro.get(17).getPrice();
        int id = Pro.get(17).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow18ActionPerformed

    private void PCartRow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow19ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(18).getModel();
        double price = Pro.get(18).getPrice();
        int id = Pro.get(18).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow19ActionPerformed

    private void PCartRow20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow20ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(19).getModel();
        double price = Pro.get(19).getPrice();
        int id = Pro.get(19).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow20ActionPerformed

    private void PCartRow21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow21ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(20).getModel();
        double price = Pro.get(20).getPrice();
        int id = Pro.get(20).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow21ActionPerformed

    private void PCartRow22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow22ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(21).getModel();
        double price = Pro.get(21).getPrice();
        int id = Pro.get(21).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow22ActionPerformed

    private void PCartRow23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow23ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(22).getModel();
        double price = Pro.get(22).getPrice();
        int id = Pro.get(22).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow23ActionPerformed

    private void PCartRow24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow24ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(23).getModel();
        double price = Pro.get(23).getPrice();
        int id = Pro.get(23).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow24ActionPerformed

    private void PCartRow25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow25ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(24).getModel();
        double price = Pro.get(24).getPrice();
        int id = Pro.get(24).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow25ActionPerformed

    private void PCartRow26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCartRow26ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        
        String item = Pro.get(25).getModel();
        double price = Pro.get(25).getPrice();
        int id = Pro.get(25).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PCartRow26ActionPerformed

    private void RamCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow1ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(0).getModel() + " " + ram.get(0).getMemoryBus() + " " + ram.get(0).getCapacity() + " GB";
        double price = ram.get(0).getPrice();
        int id = ram.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow1ActionPerformed

    private void RAMRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow1ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(0).getRating(), query, q, 301);
    }//GEN-LAST:event_RAMRateRow1ActionPerformed

    private void RamCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow2ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(1).getModel() + " " + ram.get(1).getMemoryBus() + " " + ram.get(1).getCapacity() + " GB";
        double price = ram.get(1).getPrice();
        int id = ram.get(1).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow2ActionPerformed

    private void RamCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow3ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(2).getModel() + " " + ram.get(2).getMemoryBus() + " " + ram.get(2).getCapacity() + " GB";
        double price = ram.get(2).getPrice();
        int id = ram.get(2).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow3ActionPerformed

    private void RamCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow4ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(3).getModel() + " " + ram.get(3).getMemoryBus() + " " + ram.get(3).getCapacity() + " GB";
        double price = ram.get(3).getPrice();
        int id = ram.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow4ActionPerformed

    private void RamCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow5ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(4).getModel() + " " + ram.get(4).getMemoryBus() + " " + ram.get(4).getCapacity() + " GB";
        double price = ram.get(4).getPrice();
        int id = ram.get(4).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow5ActionPerformed

    private void RamCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow6ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(5).getModel() + " " + ram.get(5).getMemoryBus() + " " + ram.get(5).getCapacity() + " GB";
        double price = ram.get(5).getPrice();
        int id = ram.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow6ActionPerformed

    private void RamCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow7ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(6).getModel() + " " + ram.get(6).getMemoryBus() + " " + ram.get(6).getCapacity() + " GB";
        double price = ram.get(6).getPrice();
        int id = ram.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow7ActionPerformed

    private void RamCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow8ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(7).getModel() + " " + ram.get(7).getMemoryBus() + " " + ram.get(7).getCapacity() + " GB";
        double price = ram.get(7).getPrice();
        int id = ram.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow8ActionPerformed

    private void RamCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow9ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(8).getModel() + " " + ram.get(8).getMemoryBus() + " " + ram.get(8).getCapacity() + " GB";
        double price = ram.get(8).getPrice();
        int id = ram.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow9ActionPerformed

    private void RamCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow10ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(9).getModel() + " " + ram.get(9).getMemoryBus() + " " + ram.get(9).getCapacity() + " GB";
        double price = ram.get(9).getPrice();
        int id = ram.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow10ActionPerformed

    private void RamCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow11ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(10).getModel() + " " + ram.get(10).getMemoryBus() + " " + ram.get(10).getCapacity() + " GB";
        double price = ram.get(10).getPrice();
        int id = ram.get(10).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow11ActionPerformed

    private void RamCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow12ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(11).getModel() + " " + ram.get(11).getMemoryBus() + " " + ram.get(11).getCapacity() + " GB";
        double price = ram.get(11).getPrice();
        int id = ram.get(11).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow12ActionPerformed

    private void RamCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow13ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(12).getModel() + " " + ram.get(12).getMemoryBus() + " " + ram.get(12).getCapacity() + " GB";
        double price = ram.get(12).getPrice();
        int id = ram.get(12).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow13ActionPerformed

    private void RamCartRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow14ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(13).getModel() + " " + ram.get(13).getMemoryBus() + " " + ram.get(13).getCapacity() + " GB";
        double price = ram.get(13).getPrice();
        int id = ram.get(13).getId();

        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow14ActionPerformed

    private void RamCartRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow15ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(14).getModel() + " " + ram.get(14).getMemoryBus() + " " + ram.get(14).getCapacity() + " GB";
        double price = ram.get(14).getPrice();
        int id = ram.get(14).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow15ActionPerformed

    private void RamCartRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamCartRow16ActionPerformed
        ArrayList<RAM> ram = getRAMTable();

        String item = ram.get(15).getModel() + " " + ram.get(15).getMemoryBus() + " " + ram.get(15).getCapacity() + " GB";
        double price = ram.get(15).getPrice();
        int id = ram.get(15).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_RamCartRow16ActionPerformed

    private void RAMRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow2ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(1).getRating(), query, q, 302);
    }//GEN-LAST:event_RAMRateRow2ActionPerformed

    private void RAMRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow3ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(2).getRating(), query, q, 303);
    }//GEN-LAST:event_RAMRateRow3ActionPerformed

    private void RAMRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow4ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(3).getRating(), query, q, 304);
    }//GEN-LAST:event_RAMRateRow4ActionPerformed

    private void RAMRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow5ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(4).getRating(), query, q, 305);
    }//GEN-LAST:event_RAMRateRow5ActionPerformed

    private void RAMRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow6ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(5).getRating(), query, q, 306);
    }//GEN-LAST:event_RAMRateRow6ActionPerformed

    private void RAMRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow7ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(6).getRating(), query, q, 307);
    }//GEN-LAST:event_RAMRateRow7ActionPerformed

    private void RAMRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow8ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(7).getRating(), query, q, 308);
    }//GEN-LAST:event_RAMRateRow8ActionPerformed

    private void RAMRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow9ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(8).getRating(), query, q, 309);
    }//GEN-LAST:event_RAMRateRow9ActionPerformed

    private void RAMRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow10ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(9).getRating(), query, q, 3010);
    }//GEN-LAST:event_RAMRateRow10ActionPerformed

    private void RAMRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow11ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(10).getRating(), query, q, 311);
    }//GEN-LAST:event_RAMRateRow11ActionPerformed

    private void RAMRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow12ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(11).getRating(), query, q, 312);
    }//GEN-LAST:event_RAMRateRow12ActionPerformed

    private void RAMRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow13ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(12).getRating(), query, q, 313);
    }//GEN-LAST:event_RAMRateRow13ActionPerformed

    private void RAMRateRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow14ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(13).getRating(), query, q, 314);
    }//GEN-LAST:event_RAMRateRow14ActionPerformed

    private void RAMRateRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow15ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(14).getRating(), query, q, 315);
    }//GEN-LAST:event_RAMRateRow15ActionPerformed

    private void RAMRateRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRateRow16ActionPerformed
        ArrayList<RAM> ram = getRAMTable();
        String query = "Update ram set Rating='";
        String q = "'where RAM_ID ='";
        RatingFrame RF = new RatingFrame (ram.get(15).getRating(), query, q, 316);
    }//GEN-LAST:event_RAMRateRow16ActionPerformed

    private void GCardCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow1ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(0).getChipset() + " " + gc.get(0).getEngineModel();
        double price = gc.get(0).getPrice();
        int id = gc.get(0).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);       
    }//GEN-LAST:event_GCardCartRow1ActionPerformed

    private void GCardRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow1ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(0).getRating(), query, q, 701);
    }//GEN-LAST:event_GCardRateRow1ActionPerformed

    private void GCardCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow2ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(1).getChipset() + " " + gc.get(1).getEngineModel();
        double price = gc.get(1).getPrice();
        int id = gc.get(1).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow2ActionPerformed

    private void GCardCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow3ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(2).getChipset() + " " + gc.get(2).getEngineModel();
        double price = gc.get(2).getPrice();
        int id = gc.get(2).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow3ActionPerformed

    private void GCardCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow4ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(3).getChipset() + " " + gc.get(3).getEngineModel();
        double price = gc.get(3).getPrice();
        int id = gc.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow4ActionPerformed

    private void GCardCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow5ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(4).getChipset() + " " + gc.get(4).getEngineModel();
        double price = gc.get(4).getPrice();
        int id = gc.get(4).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow5ActionPerformed

    private void GCardCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow6ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(5).getChipset() + " " + gc.get(5).getEngineModel();
        double price = gc.get(5).getPrice();
        int id = gc.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow6ActionPerformed

    private void GCardCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow7ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(6).getChipset() + " " + gc.get(6).getEngineModel();
        double price = gc.get(6).getPrice();
        int id = gc.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow7ActionPerformed

    private void GCardCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow8ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(7).getChipset() + " " + gc.get(7).getEngineModel();
        double price = gc.get(7).getPrice();
        int id = gc.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow8ActionPerformed

    private void GCardCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow9ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(8).getChipset() + " " + gc.get(8).getEngineModel();
        double price = gc.get(8).getPrice();
        int id = gc.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow9ActionPerformed

    private void GCardCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow10ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(9).getChipset() + " " + gc.get(9).getEngineModel();
        double price = gc.get(9).getPrice();
        int id = gc.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow10ActionPerformed

    private void GCardCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow11ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(10).getChipset() + " " + gc.get(10).getEngineModel();
        double price = gc.get(10).getPrice();
        int id = gc.get(10).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow11ActionPerformed

    private void GCardCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow12ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(11).getChipset() + " " + gc.get(11).getEngineModel();
        double price = gc.get(11).getPrice();
        int id = gc.get(11).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow12ActionPerformed

    private void GCardCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow13ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(12).getChipset() + " " + gc.get(12).getEngineModel();
        double price = gc.get(12).getPrice();
        int id = gc.get(12).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow13ActionPerformed

    private void GCardCartRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow14ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(13).getChipset() + " " + gc.get(13).getEngineModel();
        double price = gc.get(13).getPrice();
        int id = gc.get(13).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow14ActionPerformed

    private void GCardCartRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow15ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(14).getChipset() + " " + gc.get(14).getEngineModel();
        double price = gc.get(14).getPrice();
        int id = gc.get(14).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow15ActionPerformed

    private void GCardCartRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow16ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(15).getChipset() + " " + gc.get(15).getEngineModel();
        double price = gc.get(15).getPrice();
        int id = gc.get(15).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow16ActionPerformed

    private void GCardCartRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow17ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(16).getChipset() + " " + gc.get(16).getEngineModel();
        double price = gc.get(16).getPrice();
        int id = gc.get(16).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow17ActionPerformed

    private void GCardCartRow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow18ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(17).getChipset() + " " + gc.get(17).getEngineModel();
        double price = gc.get(17).getPrice();
        int id = gc.get(17).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow18ActionPerformed

    private void GCardCartRow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow19ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(18).getChipset() + " " + gc.get(18).getEngineModel();
        double price = gc.get(18).getPrice();
        int id = gc.get(18).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow19ActionPerformed

    private void GCardCartRow20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow20ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(19).getChipset() + " " + gc.get(19).getEngineModel();
        double price = gc.get(19).getPrice();
        int id = gc.get(19).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow20ActionPerformed

    private void GCardCartRow21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow21ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(20).getChipset() + " " + gc.get(20).getEngineModel();
        double price = gc.get(20).getPrice();
        int id = gc.get(20).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow21ActionPerformed

    private void GCardCartRow22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow22ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(21).getChipset() + " " + gc.get(21).getEngineModel();
        double price = gc.get(21).getPrice();
        int id = gc.get(21).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow22ActionPerformed

    private void GCardCartRow23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardCartRow23ActionPerformed
        ArrayList<GraphicsCard> gc = getGCardTable();
        
        String item = gc.get(22).getChipset() + " " + gc.get(22).getEngineModel();
        double price = gc.get(22).getPrice();
        int id = gc.get(22).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_GCardCartRow23ActionPerformed

    private void GCardRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow2ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(1).getRating(), query, q, 702);
    }//GEN-LAST:event_GCardRateRow2ActionPerformed

    private void GCardRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow3ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(2).getRating(), query, q, 703);
    }//GEN-LAST:event_GCardRateRow3ActionPerformed

    private void GCardRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow4ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(3).getRating(), query, q, 704);
    }//GEN-LAST:event_GCardRateRow4ActionPerformed

    private void GCardRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow5ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(4).getRating(), query, q, 705);
    }//GEN-LAST:event_GCardRateRow5ActionPerformed

    private void GCardRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow6ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(5).getRating(), query, q, 706);
    }//GEN-LAST:event_GCardRateRow6ActionPerformed

    private void GCardRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow7ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(6).getRating(), query, q, 707);
    }//GEN-LAST:event_GCardRateRow7ActionPerformed

    private void GCardRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow8ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(7).getRating(), query, q, 708);
    }//GEN-LAST:event_GCardRateRow8ActionPerformed

    private void GCardRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow9ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(8).getRating(), query, q, 709);
    }//GEN-LAST:event_GCardRateRow9ActionPerformed

    private void GCardRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow10ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(9).getRating(), query, q, 710);
    }//GEN-LAST:event_GCardRateRow10ActionPerformed

    private void GCardRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow11ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(10).getRating(), query, q, 711);
    }//GEN-LAST:event_GCardRateRow11ActionPerformed

    private void GCardRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow12ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(11).getRating(), query, q, 712);
    }//GEN-LAST:event_GCardRateRow12ActionPerformed

    private void GCardRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow13ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(12).getRating(), query, q, 713);
    }//GEN-LAST:event_GCardRateRow13ActionPerformed

    private void GCardRateRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow14ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(13).getRating(), query, q, 714);
    }//GEN-LAST:event_GCardRateRow14ActionPerformed

    private void GCardRateRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow15ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(14).getRating(), query, q, 715);
    }//GEN-LAST:event_GCardRateRow15ActionPerformed

    private void GCardRateRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow16ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(15).getRating(), query, q, 716);
    }//GEN-LAST:event_GCardRateRow16ActionPerformed

    private void GCardRateRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow17ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(16).getRating(), query, q, 717);
    }//GEN-LAST:event_GCardRateRow17ActionPerformed

    private void GCardRateRow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow18ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(17).getRating(), query, q, 718);
    }//GEN-LAST:event_GCardRateRow18ActionPerformed

    private void GCardRateRow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow19ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(18).getRating(), query, q, 719);
    }//GEN-LAST:event_GCardRateRow19ActionPerformed

    private void GCardRateRow20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow20ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(19).getRating(), query, q, 720);
    }//GEN-LAST:event_GCardRateRow20ActionPerformed

    private void GCardRateRow21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow21ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(20).getRating(), query, q, 721);
    }//GEN-LAST:event_GCardRateRow21ActionPerformed

    private void GCardRateRow22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow22ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(21).getRating(), query, q, 722);
    }//GEN-LAST:event_GCardRateRow22ActionPerformed

    private void GCardRateRow23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCardRateRow23ActionPerformed
        ArrayList<GraphicsCard> GC = getGCardTable();
        String query = "Update graphicscard set Rating='";
        String q = "'where GCard_ID ='";
        RatingFrame RF = new RatingFrame (GC.get(22).getRating(), query, q, 723);
    }//GEN-LAST:event_GCardRateRow23ActionPerformed

    private void ProcessorRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessorRefeshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jProcessorTable.getModel();
        model.setRowCount(0);
        showProcessorTable();
    }//GEN-LAST:event_ProcessorRefeshActionPerformed

    private void PRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow2ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
         String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(1).getRating(), query, q, 102);
    }//GEN-LAST:event_PRateRow2ActionPerformed

    private void PRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow3ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
         String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(2).getRating(), query, q, 103);
    }//GEN-LAST:event_PRateRow3ActionPerformed

    private void PRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow4ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
         String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(3).getRating(), query, q, 104);
    }//GEN-LAST:event_PRateRow4ActionPerformed

    private void PRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow5ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(4).getRating(), query, q, 105);
    }//GEN-LAST:event_PRateRow5ActionPerformed

    private void PRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow6ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(5).getRating(), query, q, 106);
    }//GEN-LAST:event_PRateRow6ActionPerformed

    private void PRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow8ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(7).getRating(), query, q, 108);
    }//GEN-LAST:event_PRateRow8ActionPerformed

    private void PRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow7ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(6).getRating(), query, q, 107);
    }//GEN-LAST:event_PRateRow7ActionPerformed

    private void PRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow9ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(8).getRating(), query, q, 109);
    }//GEN-LAST:event_PRateRow9ActionPerformed

    private void PRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow10ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(9).getRating(), query, q, 110);
    }//GEN-LAST:event_PRateRow10ActionPerformed

    private void PRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow11ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(10).getRating(), query, q, 111);
    }//GEN-LAST:event_PRateRow11ActionPerformed

    private void PRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRateRow12ActionPerformed
        ArrayList<Processor> Pro = getProcessorTable();
        String query = "Update processors set Rating='";
        String q = "'where processors_ID ='";
        RatingFrame RF = new RatingFrame (Pro.get(11).getRating(), query, q, 112);
    }//GEN-LAST:event_PRateRow12ActionPerformed

    private void RAMRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRefeshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jRAMTable.getModel();
        model.setRowCount(0);
        showRAMTable();
    }//GEN-LAST:event_RAMRefeshActionPerformed

    private void RAMRefesh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMRefesh1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jGCardTable.getModel();
        model.setRowCount(0);
        showGCardTable();
    }//GEN-LAST:event_RAMRefesh1ActionPerformed

    private void MBCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow1ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(0).getModel();
        double price = mb.get(0).getPrice();
        int id = mb.get(0).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_MBCartRow1ActionPerformed

    private void MBRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow1ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(0).getRating(), query, q, 1201);
    }//GEN-LAST:event_MBRateRow1ActionPerformed

    private void MBCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow2ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(1).getModel();
        double price = mb.get(1).getPrice();
        int id = mb.get(1).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow2ActionPerformed

    private void MBRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow2ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(1).getRating(), query, q, 1202);
    }//GEN-LAST:event_MBRateRow2ActionPerformed

    private void MBCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow3ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(2).getModel();
        double price = mb.get(2).getPrice();
        int id = mb.get(2).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow3ActionPerformed

    private void MBRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow3ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(2).getRating(), query, q, 1203);
    }//GEN-LAST:event_MBRateRow3ActionPerformed

    private void MBCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow4ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(3).getModel();
        double price = mb.get(3).getPrice();
        int id = mb.get(3).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow4ActionPerformed

    private void MBRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow4ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(3).getRating(), query, q, 1204);
    }//GEN-LAST:event_MBRateRow4ActionPerformed

    private void MBCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow5ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(4).getModel();
        double price = mb.get(4).getPrice();
        int id = mb.get(4).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow5ActionPerformed

    private void MBRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow5ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(4).getRating(), query, q, 1205);
    }//GEN-LAST:event_MBRateRow5ActionPerformed

    private void MBCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow6ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(5).getModel();
        double price = mb.get(5).getPrice();
        int id = mb.get(5).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow6ActionPerformed

    private void MBRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow6ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(5).getRating(), query, q, 1206);
    }//GEN-LAST:event_MBRateRow6ActionPerformed

    private void MBCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow7ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(6).getModel();
        double price = mb.get(6).getPrice();
        int id = mb.get(6).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow7ActionPerformed

    private void MBRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow7ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(6).getRating(), query, q, 1207);
    }//GEN-LAST:event_MBRateRow7ActionPerformed

    private void MBCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow8ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(7).getModel();
        double price = mb.get(7).getPrice();
        int id = mb.get(7).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow8ActionPerformed

    private void MBRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow8ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(7).getRating(), query, q, 1208);
    }//GEN-LAST:event_MBRateRow8ActionPerformed

    private void MBCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow9ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(8).getModel();
        double price = mb.get(8).getPrice();
        int id = mb.get(8).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow9ActionPerformed

    private void MBRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow9ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(8).getRating(), query, q, 1209);
    }//GEN-LAST:event_MBRateRow9ActionPerformed

    private void MBCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow10ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(9).getModel();
        double price = mb.get(9).getPrice();
        int id = mb.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow10ActionPerformed

    private void MBRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow10ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(9).getRating(), query, q, 1210);
    }//GEN-LAST:event_MBRateRow10ActionPerformed

    private void MBCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBCartRow11ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        
        String item = mb.get(10).getModel();
        double price = mb.get(10).getPrice();
        int id = mb.get(10).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MBCartRow11ActionPerformed

    private void MBRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MBRateRow11ActionPerformed
        ArrayList<Motherboard> mb = getMotherBoardTable();
        String query = "Update motherboard set Rating='";
        String q = "'where MBoard_ID ='";
        RatingFrame RF = new RatingFrame (mb.get(10).getRating(), query, q, 1211);
    }//GEN-LAST:event_MBRateRow11ActionPerformed

    private void ProcessorRefesh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessorRefesh1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jMotherboardTable.getModel();
        model.setRowCount(0);
        showMotherboardTable();
    }//GEN-LAST:event_ProcessorRefesh1ActionPerformed

    private void HDRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jHardDiskTable.getModel();
        model.setRowCount(0);
        showHardDiskTable();
    }//GEN-LAST:event_HDRefreshActionPerformed

    private void HDCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow1ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(0).getModel() + " " + HD.get(0).getStorage() + " TB";
        double price = HD.get(0).getPrice();
        int id = HD.get(0).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);   
    }//GEN-LAST:event_HDCartRow1ActionPerformed

    private void HDRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow1ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(0).getRating(), query, q, 201);
    }//GEN-LAST:event_HDRateRow1ActionPerformed

    private void HDCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow2ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(1).getModel() + " " + HD.get(1).getStorage() + " TB";
        double price = HD.get(1).getPrice();
        int id = HD.get(1).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow2ActionPerformed

    private void HDRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow2ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(1).getRating(), query, q, 202);
    }//GEN-LAST:event_HDRateRow2ActionPerformed

    private void HDCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow3ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(2).getModel() + " " + HD.get(2).getStorage() + " TB";
        double price = HD.get(2).getPrice();
        int id = HD.get(2).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow3ActionPerformed

    private void HDRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow3ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(2).getRating(), query, q, 203);
    }//GEN-LAST:event_HDRateRow3ActionPerformed

    private void HDCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow4ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(3).getModel() + " " + HD.get(3).getStorage() + " TB";
        double price = HD.get(3).getPrice();
        int id = HD.get(3).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow4ActionPerformed

    private void HDRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow4ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(3).getRating(), query, q, 204);
    }//GEN-LAST:event_HDRateRow4ActionPerformed

    private void HDCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow5ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(4).getModel() + " " + HD.get(4).getStorage() + " TB";
        double price = HD.get(4).getPrice();
        int id = HD.get(4).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow5ActionPerformed

    private void HDRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow5ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(4).getRating(), query, q, 205);
    }//GEN-LAST:event_HDRateRow5ActionPerformed

    private void HDCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow6ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(5).getModel() + " " + HD.get(5).getStorage() + " TB";
        double price = HD.get(5).getPrice();
        int id = HD.get(5).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow6ActionPerformed

    private void HDRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow6ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(5).getRating(), query, q, 206);
    }//GEN-LAST:event_HDRateRow6ActionPerformed

    private void HDCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow7ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(6).getModel() + " " + HD.get(6).getStorage() + " TB";
        double price = HD.get(6).getPrice();
        int id = HD.get(6).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow7ActionPerformed

    private void HDRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow7ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(6).getRating(), query, q, 207);
    }//GEN-LAST:event_HDRateRow7ActionPerformed

    private void HDCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDCartRow8ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        
        String item = HD.get(7).getModel() + " " + HD.get(7).getStorage() + " TB";
        double price = HD.get(7).getPrice();
        int id = HD.get(7).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF); 
    }//GEN-LAST:event_HDCartRow8ActionPerformed

    private void HDRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDRateRow8ActionPerformed
        ArrayList<HardDisk> HD = getHardDiskTable();
        String query = "Update harddisk set Rating='";
        String q = "'where HDisk_ID ='";
        RatingFrame RF = new RatingFrame (HD.get(7).getRating(), query, q, 208);
    }//GEN-LAST:event_HDRateRow8ActionPerformed

    private void PSRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jPowerSupplyTable.getModel();
        model.setRowCount(0);
        showPowerSupplyTable();
    }//GEN-LAST:event_PSRefreshActionPerformed

    private void PSCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow1ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(0).getModel();
        double price = PS.get(0).getPrice();
        int id = PS.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow1ActionPerformed

    private void PsRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow1ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(0).getRating(), query, q, 1001);
    }//GEN-LAST:event_PsRateRow1ActionPerformed

    private void PSCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow2ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(1).getModel();
        double price = PS.get(1).getPrice();
        int id = PS.get(1).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow2ActionPerformed

    private void PsRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow2ActionPerformed
         ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(1).getRating(), query, q, 1002);
    }//GEN-LAST:event_PsRateRow2ActionPerformed

    private void PSCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow3ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(2).getModel();
        double price = PS.get(2).getPrice();
        int id = PS.get(0).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow3ActionPerformed

    private void PsRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow3ActionPerformed
         ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(2).getRating(), query, q, 1003);
    }//GEN-LAST:event_PsRateRow3ActionPerformed

    private void PSCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow4ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(3).getModel();
        double price = PS.get(3).getPrice();
        int id = PS.get(3).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow4ActionPerformed

    private void PsRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow4ActionPerformed
         ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(3).getRating(), query, q, 1004);
    }//GEN-LAST:event_PsRateRow4ActionPerformed

    private void PSCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow5ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(4).getModel();
        double price = PS.get(4).getPrice();
        int id = PS.get(4).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow5ActionPerformed

    private void PsRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow5ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(4).getRating(), query, q, 1005);
    }//GEN-LAST:event_PsRateRow5ActionPerformed

    private void PSCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow6ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(5).getModel();
        double price = PS.get(5).getPrice();
        int id = PS.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow6ActionPerformed

    private void PsRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow6ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(5).getRating(), query, q, 1006);
    }//GEN-LAST:event_PsRateRow6ActionPerformed

    private void PSCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow7ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(6).getModel();
        double price = PS.get(6).getPrice();
        int id = PS.get(6).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow7ActionPerformed

    private void PsRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow7ActionPerformed
         ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(6).getRating(), query, q, 1007);
    }//GEN-LAST:event_PsRateRow7ActionPerformed

    private void PSCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow8ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(7).getModel();
        double price = PS.get(7).getPrice();
        int id = PS.get(7).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow8ActionPerformed

    private void PsRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow8ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(7).getRating(), query, q, 1008);
    }//GEN-LAST:event_PsRateRow8ActionPerformed

    private void PSCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow9ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(8).getModel();
        double price = PS.get(8).getPrice();
        int id = PS.get(8).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow9ActionPerformed

    private void PsRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow9ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(8).getRating(), query, q, 1009);
    }//GEN-LAST:event_PsRateRow9ActionPerformed

    private void PSCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow10ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(9).getModel();
        double price = PS.get(9).getPrice();
        int id = PS.get(9).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow10ActionPerformed

    private void PsRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow10ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(9).getRating(), query, q, 1010);
    }//GEN-LAST:event_PsRateRow10ActionPerformed

    private void PSCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow11ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(10).getModel();
        double price = PS.get(10).getPrice();
        int id = PS.get(10).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow11ActionPerformed

    private void PsRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow11ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(10).getRating(), query, q, 1011);
    }//GEN-LAST:event_PsRateRow11ActionPerformed

    private void PSCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow12ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(11).getModel();
        double price = PS.get(11).getPrice();
        int id = PS.get(11).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow12ActionPerformed

    private void PsRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow12ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(11).getRating(), query, q, 1012);
    }//GEN-LAST:event_PsRateRow12ActionPerformed

    private void PSCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow13ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(12).getModel();
        double price = PS.get(12).getPrice();
        int id = PS.get(12).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow13ActionPerformed

    private void PsRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow13ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(12).getRating(), query, q, 1013);
    }//GEN-LAST:event_PsRateRow13ActionPerformed

    private void PSCartRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow14ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(13).getModel();
        double price = PS.get(13).getPrice();
        int id = PS.get(13).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow14ActionPerformed

    private void PsRateRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow14ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(13).getRating(), query, q, 1014);
    }//GEN-LAST:event_PsRateRow14ActionPerformed

    private void PSCartRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow15ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(14).getModel();
        double price = PS.get(14).getPrice();
        int id = PS.get(14).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow15ActionPerformed

    private void PsRateRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow15ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(14).getRating(), query, q, 1015);
    }//GEN-LAST:event_PsRateRow15ActionPerformed

    private void PSCartRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow16ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(15).getModel();
        double price = PS.get(15).getPrice();
        int id = PS.get(15).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow16ActionPerformed

    private void PsRateRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow16ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(15).getRating(), query, q, 1016);
    }//GEN-LAST:event_PsRateRow16ActionPerformed

    private void PSCartRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow17ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(16).getModel();
        double price = PS.get(16).getPrice();
        int id = PS.get(16).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow17ActionPerformed

    private void PsRateRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow17ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(16).getRating(), query, q, 1017);
    }//GEN-LAST:event_PsRateRow17ActionPerformed

    private void PSCartRow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow18ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(17).getModel();
        double price = PS.get(17).getPrice();
        int id = PS.get(17).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow18ActionPerformed

    private void PsRateRow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow18ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(17).getRating(), query, q, 1018);
    }//GEN-LAST:event_PsRateRow18ActionPerformed

    private void PSCartRow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow19ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(18).getModel();
        double price = PS.get(18).getPrice();
        int id = PS.get(18).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow19ActionPerformed

    private void PsRateRow19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow19ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(18).getRating(), query, q, 1019);
    }//GEN-LAST:event_PsRateRow19ActionPerformed

    private void PSCartRow20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow20ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(19).getModel();
        double price = PS.get(19).getPrice();
        int id = PS.get(19).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow20ActionPerformed

    private void PsRateRow20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow20ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(19).getRating(), query, q, 1020);
    }//GEN-LAST:event_PsRateRow20ActionPerformed

    private void PSCartRow21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow21ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(20).getModel();
        double price = PS.get(20).getPrice();
        int id = PS.get(20).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow21ActionPerformed

    private void PsRateRow21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow21ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame(PS.get(20).getRating(), query, q, 1021);
    }//GEN-LAST:event_PsRateRow21ActionPerformed

    private void PSCartRow22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSCartRow22ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        
        String item = PS.get(21).getModel();
        double price = PS.get(21).getPrice();
        int id = PS.get(21).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_PSCartRow22ActionPerformed

    private void PsRateRow22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsRateRow22ActionPerformed
        ArrayList<PowerSupply> PS = getPowerSupplyTable();
        String query = "Update powersupply set Rating='";
        String q = "'where PSupply_ID ='";
        RatingFrame RF = new RatingFrame (PS.get(21).getRating(), query, q, 1022);
    }//GEN-LAST:event_PsRateRow22ActionPerformed

    private void CasingRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasingRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jCasingTable.getModel();
        model.setRowCount(0);
        showCasingTable();
    }//GEN-LAST:event_CasingRefreshActionPerformed

    private void CCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow1ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(0).getModel();
        double price = c.get(0).getPrice();
        int id = c.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow1ActionPerformed

    private void CRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow1ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(0).getRating(), query, q, 1101);
    }//GEN-LAST:event_CRateRow1ActionPerformed

    private void CCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow2ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(1).getModel();
        double price = c.get(1).getPrice();
        int id = c.get(1).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow2ActionPerformed

    private void CRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow2ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(1).getRating(), query, q, 1102);
    }//GEN-LAST:event_CRateRow2ActionPerformed

    private void CCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow3ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(2).getModel();
        double price = c.get(2).getPrice();
        int id = c.get(2).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow3ActionPerformed

    private void CRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow3ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(2).getRating(), query, q, 1103);
    }//GEN-LAST:event_CRateRow3ActionPerformed

    private void CCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow4ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(3).getModel();
        double price = c.get(3).getPrice();
        int id = c.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow4ActionPerformed

    private void CRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow4ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(3).getRating(), query, q, 1104);
    }//GEN-LAST:event_CRateRow4ActionPerformed

    private void CCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow5ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(4).getModel();
        double price = c.get(4).getPrice();
        int id = c.get(4).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow5ActionPerformed

    private void CRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow5ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(4).getRating(), query, q, 1105);
    }//GEN-LAST:event_CRateRow5ActionPerformed

    private void CCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow6ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(5).getModel();
        double price = c.get(5).getPrice();
        int id = c.get(5).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow6ActionPerformed

    private void CRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow6ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(5).getRating(), query, q, 1106);
    }//GEN-LAST:event_CRateRow6ActionPerformed

    private void CCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow7ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(6).getModel();
        double price = c.get(6).getPrice();
        int id = c.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow7ActionPerformed

    private void CRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow7ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(6).getRating(), query, q, 1107);
    }//GEN-LAST:event_CRateRow7ActionPerformed

    private void CCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow8ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(7).getModel();
        double price = c.get(7).getPrice();
        int id = c.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow8ActionPerformed

    private void CRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow8ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(7).getRating(), query, q, 1108);
    }//GEN-LAST:event_CRateRow8ActionPerformed

    private void CCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow9ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(8).getModel();
        double price = c.get(8).getPrice();
        int id = c.get(8).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow9ActionPerformed

    private void CRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow9ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(8).getRating(), query, q, 1109);
    }//GEN-LAST:event_CRateRow9ActionPerformed

    private void CCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCartRow10ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        
        String item = c.get(9).getModel();
        double price = c.get(9).getPrice();
        int id = c.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_CCartRow10ActionPerformed

    private void CRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRateRow10ActionPerformed
        ArrayList<Casing> c = getCasingTable();
        String query = "Update casing set Rating='";
        String q = "'where Casing_ID ='";
        RatingFrame RF = new RatingFrame (c.get(9).getRating(), query, q, 1110);
    }//GEN-LAST:event_CRateRow10ActionPerformed

    private void MonitorRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonitorRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jMonitorTable.getModel();
        model.setRowCount(0);
        showMonitorTable();
    }//GEN-LAST:event_MonitorRefreshActionPerformed

    private void MonCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow1ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(0).getModel();
        double price = m.get(0).getPrice();
        int id = m.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow1ActionPerformed

    private void MonRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow1ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(0).getRating(), query, q, 401);
    }//GEN-LAST:event_MonRateRow1ActionPerformed

    private void MonCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow2ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(1).getModel();
        double price = m.get(1).getPrice();
        int id = m.get(1).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow2ActionPerformed

    private void MonRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow2ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(1).getRating(), query, q, 402);
    }//GEN-LAST:event_MonRateRow2ActionPerformed

    private void MonCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow3ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(2).getModel();
        double price = m.get(2).getPrice();
        int id = m.get(2).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow3ActionPerformed

    private void MonRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow3ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(2).getRating(), query, q, 403);
    }//GEN-LAST:event_MonRateRow3ActionPerformed

    private void MonCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow4ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(3).getModel();
        double price = m.get(3).getPrice();
        int id = m.get(3).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow4ActionPerformed

    private void MonRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow4ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(3).getRating(), query, q, 404);
    }//GEN-LAST:event_MonRateRow4ActionPerformed

    private void MonCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow5ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(4).getModel();
        double price = m.get(4).getPrice();
        int id = m.get(4).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow5ActionPerformed

    private void MonRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow5ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(4).getRating(), query, q, 405);
    }//GEN-LAST:event_MonRateRow5ActionPerformed

    private void MonCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow6ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(5).getModel();
        double price = m.get(5).getPrice();
        int id = m.get(5).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow6ActionPerformed

    private void MonRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow6ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(5).getRating(), query, q, 406);
    }//GEN-LAST:event_MonRateRow6ActionPerformed

    private void MonCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow7ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(6).getModel();
        double price = m.get(6).getPrice();
        int id = m.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow7ActionPerformed

    private void MonRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow7ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(6).getRating(), query, q, 407);
    }//GEN-LAST:event_MonRateRow7ActionPerformed

    private void MonCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow8ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(7).getModel();
        double price = m.get(7).getPrice();
        int id = m.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow8ActionPerformed

    private void MonRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow8ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(7).getRating(), query, q, 408);
    }//GEN-LAST:event_MonRateRow8ActionPerformed

    private void MonCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow9ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(8).getModel();
        double price = m.get(8).getPrice();
        int id = m.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow9ActionPerformed

    private void MonRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow9ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(8).getRating(), query, q, 409);
    }//GEN-LAST:event_MonRateRow9ActionPerformed

    private void MonCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow10ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(9).getModel();
        double price = m.get(9).getPrice();
        int id = m.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow10ActionPerformed

    private void MonRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow10ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(9).getRating(), query, q, 410);
    }//GEN-LAST:event_MonRateRow10ActionPerformed

    private void MonCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow11ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(10).getModel();
        double price = m.get(10).getPrice();
        int id = m.get(10).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow11ActionPerformed

    private void MonRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow11ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(10).getRating(), query, q, 411);
    }//GEN-LAST:event_MonRateRow11ActionPerformed

    private void MonRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow12ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(11).getRating(), query, q, 412);
    }//GEN-LAST:event_MonRateRow12ActionPerformed

    private void MonCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow12ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(11).getModel();
        double price = m.get(11).getPrice();
        int id = m.get(11).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow12ActionPerformed

    private void MonRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow13ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(12).getRating(), query, q, 413);
    }//GEN-LAST:event_MonRateRow13ActionPerformed

    private void MonCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow13ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(12).getModel();
        double price = m.get(12).getPrice();
        int id = m.get(12).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow13ActionPerformed

    private void MonRateRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow14ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(13).getRating(), query, q, 414);
    }//GEN-LAST:event_MonRateRow14ActionPerformed

    private void MonCartRow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow14ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(13).getModel();
        double price = m.get(13).getPrice();
        int id = m.get(13).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow14ActionPerformed

    private void MonRateRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow15ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(14).getRating(), query, q, 415);
    }//GEN-LAST:event_MonRateRow15ActionPerformed

    private void MonCartRow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow15ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(14).getModel();
        double price = m.get(14).getPrice();
        int id = m.get(15).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow15ActionPerformed

    private void MonRateRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow16ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(15).getRating(), query, q, 416);
    }//GEN-LAST:event_MonRateRow16ActionPerformed

    private void MonCartRow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow16ActionPerformed
       ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(15).getModel();
        double price = m.get(15).getPrice();
        int id = m.get(15).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow16ActionPerformed

    private void MonRateRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonRateRow17ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        String query = "Update monitor set Rating='";
        String q = "'where Monitor_ID ='";
        RatingFrame RF = new RatingFrame (m.get(16).getRating(), query, q, 417);
    }//GEN-LAST:event_MonRateRow17ActionPerformed

    private void MonCartRow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonCartRow17ActionPerformed
        ArrayList<Monitor> m = getMonitorTable();
        
        String item = m.get(16).getModel();
        double price = m.get(16).getPrice();
        int id = m.get(16).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MonCartRow17ActionPerformed

    private void KeyboardRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyboardRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jKeyboardTable.getModel();
        model.setRowCount(0);
        showKeyboardTable();
    }//GEN-LAST:event_KeyboardRefreshActionPerformed

    private void keyCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow1ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(0).getModel();
        double price = k.get(0).getPrice();
        int id = k.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow1ActionPerformed

    private void keyRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow1ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(0).getRating(), query, q, 501);
    }//GEN-LAST:event_keyRateRow1ActionPerformed

    private void keyCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow2ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(1).getModel();
        double price = k.get(1).getPrice();
        int id = k.get(1).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow2ActionPerformed

    private void keyRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow2ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(1).getRating(), query, q, 502);
    }//GEN-LAST:event_keyRateRow2ActionPerformed

    private void keyCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow3ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(2).getModel();
        double price = k.get(2).getPrice();
        int id = k.get(2).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow3ActionPerformed

    private void keyRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow3ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(2).getRating(), query, q, 503);
    }//GEN-LAST:event_keyRateRow3ActionPerformed

    private void keyCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow4ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(3).getModel();
        double price = k.get(3).getPrice();
        int id = k.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow4ActionPerformed

    private void keyRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow4ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(3).getRating(), query, q, 504);
    }//GEN-LAST:event_keyRateRow4ActionPerformed

    private void keyCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow5ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(4).getModel();
        double price = k.get(4).getPrice();
        int id = k.get(4).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow5ActionPerformed

    private void keyRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow5ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(4).getRating(), query, q, 505);
    }//GEN-LAST:event_keyRateRow5ActionPerformed

    private void keyCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow6ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(5).getModel();
        double price = k.get(5).getPrice();
        int id = k.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow6ActionPerformed

    private void keyRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow6ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(5).getRating(), query, q, 506);
    }//GEN-LAST:event_keyRateRow6ActionPerformed

    private void keyCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow7ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(6).getModel();
        double price = k.get(6).getPrice();
        int id = k.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow7ActionPerformed

    private void keyRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow7ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(6).getRating(), query, q, 507);
    }//GEN-LAST:event_keyRateRow7ActionPerformed

    private void keyCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow8ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        
        String item = k.get(7).getModel();
        double price = k.get(7).getPrice();
        int id = k.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow8ActionPerformed

    private void keyRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow8ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(7).getRating(), query, q, 508);
    }//GEN-LAST:event_keyRateRow8ActionPerformed

    private void keyCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyCartRow9ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();

        String item = k.get(8).getModel();
        double price = k.get(8).getPrice();
        int id = k.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_keyCartRow9ActionPerformed

    private void keyRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRateRow9ActionPerformed
        ArrayList<Keyboard> k = getKeyboardTable();
        String query = "Update keyboard set Rating='";
        String q = "'where K_ID ='";
        RatingFrame RF = new RatingFrame (k.get(8).getRating(), query, q, 509);
    }//GEN-LAST:event_keyRateRow9ActionPerformed

    private void KeyboardRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyboardRefresh1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jMouseTable.getModel();
        model.setRowCount(0);
        showMouseTable();
    }//GEN-LAST:event_KeyboardRefresh1ActionPerformed

    private void MouseCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow1ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(0).getModel();
        double price = mo.get(0).getPrice();
        int id = mo.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow1ActionPerformed

    private void MouseRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow1ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(0).getRating(), query, q, 601);
    }//GEN-LAST:event_MouseRateRow1ActionPerformed

    private void MouseCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow2ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(1).getModel();
        double price = mo.get(1).getPrice();
        int id = mo.get(1).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow2ActionPerformed

    private void MouseRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow2ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(1).getRating(), query, q, 602);
    }//GEN-LAST:event_MouseRateRow2ActionPerformed

    private void MouseCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow3ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(2).getModel();
        double price = mo.get(2).getPrice();
        int id = mo.get(2).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow3ActionPerformed

    private void MouseRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow3ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(2).getRating(), query, q, 603);
    }//GEN-LAST:event_MouseRateRow3ActionPerformed

    private void MouseCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow4ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(3).getModel();
        double price = mo.get(3).getPrice();
        int id = mo.get(3).getId();

        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow4ActionPerformed

    private void MouseRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow4ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(3).getRating(), query, q, 604);
    }//GEN-LAST:event_MouseRateRow4ActionPerformed

    private void MouseCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow5ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(4).getModel();
        double price = mo.get(4).getPrice();
        int id = mo.get(4).getId();
        
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow5ActionPerformed

    private void MouseRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow5ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(4).getRating(), query, q, 605);
    }//GEN-LAST:event_MouseRateRow5ActionPerformed

    private void MouseCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow6ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(5).getModel();
        double price = mo.get(5).getPrice();
        int id = mo.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow6ActionPerformed

    private void MouseRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow6ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(5).getRating(), query, q, 606);
    }//GEN-LAST:event_MouseRateRow6ActionPerformed

    private void MouseCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow7ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(6).getModel();
        double price = mo.get(6).getPrice();
        int id = mo.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow7ActionPerformed

    private void MouseRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow7ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(6).getRating(), query, q, 607);
    }//GEN-LAST:event_MouseRateRow7ActionPerformed

    private void MouseCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow8ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(7).getModel();
        double price = mo.get(7).getPrice();
        int id = mo.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow8ActionPerformed

    private void MouseRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow8ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(7).getRating(), query, q, 608);
    }//GEN-LAST:event_MouseRateRow8ActionPerformed

    private void MouseCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow9ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(8).getModel();
        double price = mo.get(8).getPrice();
        int id = mo.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow9ActionPerformed

    private void MouseRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow9ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(8).getRating(), query, q, 609);
    }//GEN-LAST:event_MouseRateRow9ActionPerformed

    private void MouseRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow10ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(9).getRating(), query, q, 610);
    }//GEN-LAST:event_MouseRateRow10ActionPerformed

    private void MouseCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow10ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(9).getModel();
        double price = mo.get(9).getPrice();
        int id = mo.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow10ActionPerformed

    private void MouseRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow11ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(10).getRating(), query, q, 611);
    }//GEN-LAST:event_MouseRateRow11ActionPerformed

    private void MouseCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow11ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(10).getModel();
        double price = mo.get(10).getPrice();
        int id = mo.get(10).getId();

        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow11ActionPerformed

    private void MouseRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow12ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(11).getRating(), query, q, 612);
    }//GEN-LAST:event_MouseRateRow12ActionPerformed

    private void MouseCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow12ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(11).getModel();
        double price = mo.get(11).getPrice();
        int id = mo.get(10).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow12ActionPerformed

    private void MouseRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseRateRow13ActionPerformed
        ArrayList<Mouse> mo = getMouseTable();
        String query = "Update Mouse set Rating='";
        String q = "'where Mouse_ID ='";
        RatingFrame RF = new RatingFrame (mo.get(12).getRating(), query, q, 613);
    }//GEN-LAST:event_MouseRateRow13ActionPerformed

    private void MouseCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseCartRow13ActionPerformed
         ArrayList<Mouse> mo = getMouseTable();

        String item = mo.get(12).getModel();
        double price = mo.get(12).getPrice();
        int id = mo.get(12).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_MouseCartRow13ActionPerformed

    private void SSRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jSSTable.getModel();
        model.setRowCount(0);
        showSoundSystemTable();
    }//GEN-LAST:event_SSRefreshActionPerformed

    private void UPSRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRefreshActionPerformed
        DefaultTableModel model = (DefaultTableModel) jUPSTable.getModel();
        model.setRowCount(0);
        showUPSTable();
    }//GEN-LAST:event_UPSRefreshActionPerformed

    private void SSCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow1ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(0).getModel();
        double price = ss.get(0).getPrice();
        int id = ss.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow1ActionPerformed

    private void SSRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow1ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(0).getRating(), query, q, 901);
    }//GEN-LAST:event_SSRateRow1ActionPerformed

    private void SSCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow2ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(1).getModel();
        double price = ss.get(1).getPrice();
        int id = ss.get(1).getId();

        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow2ActionPerformed

    private void SSRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow2ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(1).getRating(), query, q, 902);
    }//GEN-LAST:event_SSRateRow2ActionPerformed

    private void SSCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow3ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(2).getModel();
        double price = ss.get(2).getPrice();
        int id = ss.get(2).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow3ActionPerformed

    private void SSRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow3ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(2).getRating(), query, q, 903);
    }//GEN-LAST:event_SSRateRow3ActionPerformed

    private void SSCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow4ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(3).getModel();
        double price = ss.get(3).getPrice();
        int id = ss.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow4ActionPerformed

    private void SSRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow4ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(3).getRating(), query, q, 904);
    }//GEN-LAST:event_SSRateRow4ActionPerformed

    private void SSCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow5ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(4).getModel();
        double price = ss.get(4).getPrice();
        int id = ss.get(4).getId();

        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow5ActionPerformed

    private void SSRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow5ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(4).getRating(), query, q, 905);
    }//GEN-LAST:event_SSRateRow5ActionPerformed

    private void SSRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRow6ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(5).getModel();
        double price = ss.get(5).getPrice();
        int id = ss.get(5).getId();

        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSRow6ActionPerformed

    private void SSRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow6ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(5).getRating(), query, q, 906);
    }//GEN-LAST:event_SSRateRow6ActionPerformed

    private void SSCartRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow7ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(6).getModel();
        double price = ss.get(6).getPrice();
        int id = ss.get(6).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow7ActionPerformed

    private void SSRateRow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow7ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(6).getRating(), query, q, 907);
    }//GEN-LAST:event_SSRateRow7ActionPerformed

    private void SSCartRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow8ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(7).getModel();
        double price = ss.get(7).getPrice();
        int id = ss.get(7).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow8ActionPerformed

    private void SSRateRow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow8ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(7).getRating(), query, q, 908);
    }//GEN-LAST:event_SSRateRow8ActionPerformed

    private void SSCartRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow9ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(8).getModel();
        double price = ss.get(8).getPrice();
        int id = ss.get(8).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow9ActionPerformed

    private void SSRateRow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow9ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(8).getRating(), query, q, 909);
    }//GEN-LAST:event_SSRateRow9ActionPerformed

    private void SSRateRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow10ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(9).getRating(), query, q, 910);
    }//GEN-LAST:event_SSRateRow10ActionPerformed

    private void SSCartRow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow10ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(9).getModel();
        double price = ss.get(9).getPrice();
        int id = ss.get(9).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow10ActionPerformed

    private void SSRateRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow11ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(10).getRating(), query, q, 911);
    }//GEN-LAST:event_SSRateRow11ActionPerformed

    private void SSCartRow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow11ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(10).getModel();
        double price = ss.get(10).getPrice();
        int id = ss.get(10).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow11ActionPerformed

    private void SSRateRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow12ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(11).getRating(), query, q, 912);
    }//GEN-LAST:event_SSRateRow12ActionPerformed

    private void SSCartRow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow12ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(11).getModel();
        double price = ss.get(11).getPrice();
        int id = ss.get(11).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow12ActionPerformed

    private void SSRateRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSRateRow13ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();
        String query = "Update soundsystem set Rating='";
        String q = "'where SoundS_ID ='";
        RatingFrame RF = new RatingFrame (ss.get(12).getRating(), query, q, 913);
    }//GEN-LAST:event_SSRateRow13ActionPerformed

    private void SSCartRow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCartRow13ActionPerformed
        ArrayList<SoundSystem> ss = getSoundSystemTable();

        String item = ss.get(12).getModel();
        double price = ss.get(12).getPrice();
        int id = ss.get(12).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_SSCartRow13ActionPerformed

    private void UPSCartRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSCartRow1ActionPerformed
        ArrayList<UPS> up = getUPSTable();

        String item = up.get(0).getModel();
        double price = up.get(0).getPrice();
        int id = up.get(0).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_UPSCartRow1ActionPerformed

    private void UPSRateRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRateRow1ActionPerformed
        ArrayList<UPS> up = getUPSTable();
        String query = "Update ups set Rating='";
        String q = "'where UPS_ID ='";
        RatingFrame RF = new RatingFrame (up.get(0).getRating(), query, q, 801);
    }//GEN-LAST:event_UPSRateRow1ActionPerformed

    private void UPSCartRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSCartRow2ActionPerformed
        ArrayList<UPS> up = getUPSTable();

        String item = up.get(1).getModel();
        double price = up.get(1).getPrice();
        int id = up.get(1).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_UPSCartRow2ActionPerformed

    private void UPSRateRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRateRow2ActionPerformed
        ArrayList<UPS> up = getUPSTable();
        String query = "Update ups set Rating='";
        String q = "'where UPS_ID ='";
        RatingFrame RF = new RatingFrame (up.get(1).getRating(), query, q, 802);
    }//GEN-LAST:event_UPSRateRow2ActionPerformed

    private void UPSCartRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSCartRow3ActionPerformed
        ArrayList<UPS> up = getUPSTable();

        String item = up.get(2).getModel();
        double price = up.get(2).getPrice();
        int id = up.get(2).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_UPSCartRow3ActionPerformed

    private void UPSRateRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRateRow3ActionPerformed
        ArrayList<UPS> up = getUPSTable();
        String query = "Update ups set Rating='";
        String q = "'where UPS_ID ='";
        RatingFrame RF = new RatingFrame (up.get(2).getRating(), query, q, 803);
    }//GEN-LAST:event_UPSRateRow3ActionPerformed

    private void UPSCartRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSCartRow4ActionPerformed
        ArrayList<UPS> up = getUPSTable();

        String item = up.get(3).getModel();
        double price = up.get(3).getPrice();
        int id = up.get(3).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_UPSCartRow4ActionPerformed

    private void UPSRateRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRateRow4ActionPerformed
        ArrayList<UPS> up = getUPSTable();
        String query = "Update ups set Rating='";
        String q = "'where UPS_ID ='";
        RatingFrame RF = new RatingFrame (up.get(3).getRating(), query, q, 804);
    }//GEN-LAST:event_UPSRateRow4ActionPerformed

    private void UPSCartRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSCartRow5ActionPerformed
        ArrayList<UPS> up = getUPSTable();

        String item = up.get(4).getModel();
        double price = up.get(4).getPrice();
        int id = up.get(4).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_UPSCartRow5ActionPerformed

    private void UPSRateRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRateRow5ActionPerformed
        ArrayList<UPS> up = getUPSTable();
        String query = "Update ups set Rating='";
        String q = "'where UPS_ID ='";
        RatingFrame RF = new RatingFrame (up.get(4).getRating(), query, q, 805);
    }//GEN-LAST:event_UPSRateRow5ActionPerformed

    private void UPSCartRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSCartRow6ActionPerformed
        ArrayList<UPS> up = getUPSTable();

        String item = up.get(5).getModel();
        double price = up.get(5).getPrice();
        int id = up.get(5).getId();
        AddToCart ATC = new AddToCart (id, item, price, CF);
    }//GEN-LAST:event_UPSCartRow6ActionPerformed

    private void UPSRateRow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSRateRow6ActionPerformed
        ArrayList<UPS> up = getUPSTable();
        String query = "Update ups set Rating='";
        String q = "'where UPS_ID ='";
        RatingFrame RF = new RatingFrame (up.get(5).getRating(), query, q, 806);
    }//GEN-LAST:event_UPSRateRow6ActionPerformed

    private void SearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyReleased
        
    }//GEN-LAST:event_SearchTextFieldKeyReleased

    private void SearchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyPressed
        
    }//GEN-LAST:event_SearchTextFieldKeyPressed

    private void Home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home1ActionPerformed
       select++;

        if (select % 2 == 0) 
        {
            home = 1;
            Office1.setEnabled(false);
            Game1.setEnabled(false);
        }
        
        else {
            home = 0;
            Office1.setEnabled(true);
            Game1.setEnabled(true);
        }
    }//GEN-LAST:event_Home1ActionPerformed

    private void Game1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Game1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            game = 1;
            Home1.setEnabled(false);
            Office1.setEnabled(false);
        }
        
        else {
            game = 0;
            Home1.setEnabled(true);
            Office1.setEnabled(true);
        }
    }//GEN-LAST:event_Game1ActionPerformed

    private void MinP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinP1ActionPerformed
        Minprice = Double.parseDouble(MinP1.getText());
    }//GEN-LAST:event_MinP1ActionPerformed

    private void MaxP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxP1ActionPerformed
        Maxprice = Double.parseDouble(MaxP1.getText());
    }//GEN-LAST:event_MaxP1ActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        CardMainPanel.removeAll();
        CardMainPanel.add(SuggestionsPanel);
        CardMainPanel.repaint();
        CardMainPanel.revalidate();
        SearchTextField.setText(null);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SugestionConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SugestionConfirm1ActionPerformed
        if((Office1.isSelected() || Home1.isSelected() || Game1.isSelected()) && (!MaxP1.getText().isEmpty()) && (GraphicsYes1.isSelected() || GraphicsNo1.isSelected()) && (UPSYes1.isSelected() || UPSNo1.isSelected()) && (SSYes1.isSelected() || SSNo1.isSelected()))
        {
            
            try {
                DBConnect();

                String sql1 = "SELECT * from pc_solution WHERE price <=" + Maxprice + "having Max(rating)";
                pst = con.prepareStatement(sql1);
                rs = pst.executeQuery();
                
                 if (rs.next())
                 {
              
                 }
                
                //int monitor = rs.getInt("Monitor_ID");
                //int ouse = rs.getInt("Mouse_ID");
                //int keyboard = rs.getInt("K_ID");
                //int ss = rs.getInt("SoundS_ID");
                //int ups = rs.getInt("UPS_ID");
                //double p = rs.getDouble ("Price");
                
                //MonitorTextField.setText();
                //KeyboardTextField.setText();
                //MouseTextField.setText();
                //SSTextField.setText();
                //UPSTextField.setText();
                //TotalPriceField.setText(String.valueOf(new Double(p)));
                

            
            
            
            
            
            
            } catch (Exception ex) {
                System.out.println("Error:" + ex);
            }  
            
            CardMainPanel.removeAll();
            CardMainPanel.add(SuggestionShow);
            CardMainPanel.repaint();
            CardMainPanel.revalidate();
            SearchTextField.setText(null);
        }
        else
        {
            Selection.main(null);
        }
    }//GEN-LAST:event_SugestionConfirm1ActionPerformed

    private void Office1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Office1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            office = 1;
            Home1.setEnabled(false);
            Game1.setEnabled(false);
        }
        
        else {
            office = 0;
            Home1.setEnabled(true);
            Game1.setEnabled(true);
        }
    }//GEN-LAST:event_Office1ActionPerformed

    private void GraphicsYes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsYes1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            gcard = 1;
            GraphicsNo1.setEnabled(false);
        }
        
        else {
            gcard = 0;
            GraphicsNo1.setEnabled(true);
        }
    }//GEN-LAST:event_GraphicsYes1ActionPerformed

    private void GraphicsNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsNo1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            gcard = 0;
            GraphicsYes1.setEnabled(false);
        }
        
        else {
            gcard = 0;
            GraphicsYes1.setEnabled(true);
        }
    }//GEN-LAST:event_GraphicsNo1ActionPerformed

    private void UPSYes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSYes1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            ups = 1;
            UPSNo1.setEnabled(false);
        }
        
        else {
            ups = 0;
            UPSNo1.setEnabled(true);
        }
    }//GEN-LAST:event_UPSYes1ActionPerformed

    private void UPSNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSNo1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            ups = 1;
            UPSYes1.setEnabled(false);
        }
        
        else {
            ups = 0;
            UPSYes1.setEnabled(true);
        }
    }//GEN-LAST:event_UPSNo1ActionPerformed

    private void SSYes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSYes1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            ss = 1;
            SSNo1.setEnabled(false);
        }
        
        else {
            ss = 0;
            SSNo1.setEnabled(true);
        }
    }//GEN-LAST:event_SSYes1ActionPerformed

    private void SSNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSNo1ActionPerformed
        select++;

        if (select % 2 == 0) 
        {
            ss = 1;
            SSYes1.setEnabled(false);
        }
        
        else {
            ss = 0;
            SSYes1.setEnabled(true);
        }
    }//GEN-LAST:event_SSNo1ActionPerformed

    private void ProcessorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessorTextFieldActionPerformed

    private void MotherboardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotherboardTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MotherboardTextFieldActionPerformed

    private void RamTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RamTextFieldActionPerformed

    private void GraphicsCardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsCardTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphicsCardTextFieldActionPerformed

    private void HardDiskTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardDiskTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HardDiskTextFieldActionPerformed

    private void PowerSupplyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyTextFieldActionPerformed

    private void CasingTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasingTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CasingTextFieldActionPerformed

    private void MonitorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonitorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonitorTextFieldActionPerformed

    private void KeyboardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyboardTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeyboardTextFieldActionPerformed

    private void MouseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MouseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MouseTextFieldActionPerformed

    private void SSTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SSTextFieldActionPerformed

    private void UPSTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPSTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPSTextFieldActionPerformed

    private void TotalPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalPriceFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArrowLogoLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JScrollPane ButtonScrollPane;
    private javax.swing.JButton CCartRow1;
    private javax.swing.JButton CCartRow10;
    private javax.swing.JButton CCartRow2;
    private javax.swing.JButton CCartRow3;
    private javax.swing.JButton CCartRow4;
    private javax.swing.JButton CCartRow5;
    private javax.swing.JButton CCartRow6;
    private javax.swing.JButton CCartRow7;
    private javax.swing.JButton CCartRow8;
    private javax.swing.JButton CCartRow9;
    private javax.swing.JPanel CPUComponentsPanel;
    private javax.swing.JLabel CPU_ComponentLabel;
    private javax.swing.JButton CRateRow1;
    private javax.swing.JButton CRateRow10;
    private javax.swing.JButton CRateRow2;
    private javax.swing.JButton CRateRow3;
    private javax.swing.JButton CRateRow4;
    private javax.swing.JButton CRateRow5;
    private javax.swing.JButton CRateRow6;
    private javax.swing.JButton CRateRow7;
    private javax.swing.JButton CRateRow8;
    private javax.swing.JButton CRateRow9;
    private javax.swing.JPanel CardMainPanel;
    private javax.swing.JButton CartButton;
    private javax.swing.JButton CasingButton;
    private javax.swing.JLabel CasingLogo;
    private javax.swing.JPanel CasingPane1;
    private javax.swing.JPanel CasingPanel;
    private javax.swing.JButton CasingRefresh;
    private javax.swing.JScrollPane CasingScrollPane;
    private javax.swing.JTextField CasingTextField;
    private javax.swing.JPanel ComponentsPanel;
    private javax.swing.JButton GCardCartRow1;
    private javax.swing.JButton GCardCartRow10;
    private javax.swing.JButton GCardCartRow11;
    private javax.swing.JButton GCardCartRow12;
    private javax.swing.JButton GCardCartRow13;
    private javax.swing.JButton GCardCartRow14;
    private javax.swing.JButton GCardCartRow15;
    private javax.swing.JButton GCardCartRow16;
    private javax.swing.JButton GCardCartRow17;
    private javax.swing.JButton GCardCartRow18;
    private javax.swing.JButton GCardCartRow19;
    private javax.swing.JButton GCardCartRow2;
    private javax.swing.JButton GCardCartRow20;
    private javax.swing.JButton GCardCartRow21;
    private javax.swing.JButton GCardCartRow22;
    private javax.swing.JButton GCardCartRow23;
    private javax.swing.JButton GCardCartRow3;
    private javax.swing.JButton GCardCartRow4;
    private javax.swing.JButton GCardCartRow5;
    private javax.swing.JButton GCardCartRow6;
    private javax.swing.JButton GCardCartRow7;
    private javax.swing.JButton GCardCartRow8;
    private javax.swing.JButton GCardCartRow9;
    private javax.swing.JPanel GCardPanel1;
    private javax.swing.JButton GCardRateRow1;
    private javax.swing.JButton GCardRateRow10;
    private javax.swing.JButton GCardRateRow11;
    private javax.swing.JButton GCardRateRow12;
    private javax.swing.JButton GCardRateRow13;
    private javax.swing.JButton GCardRateRow14;
    private javax.swing.JButton GCardRateRow15;
    private javax.swing.JButton GCardRateRow16;
    private javax.swing.JButton GCardRateRow17;
    private javax.swing.JButton GCardRateRow18;
    private javax.swing.JButton GCardRateRow19;
    private javax.swing.JButton GCardRateRow2;
    private javax.swing.JButton GCardRateRow20;
    private javax.swing.JButton GCardRateRow21;
    private javax.swing.JButton GCardRateRow22;
    private javax.swing.JButton GCardRateRow23;
    private javax.swing.JButton GCardRateRow3;
    private javax.swing.JButton GCardRateRow4;
    private javax.swing.JButton GCardRateRow5;
    private javax.swing.JButton GCardRateRow6;
    private javax.swing.JButton GCardRateRow7;
    private javax.swing.JButton GCardRateRow8;
    private javax.swing.JButton GCardRateRow9;
    private javax.swing.JScrollPane GCardScrollPane;
    private javax.swing.JCheckBox Game1;
    private javax.swing.JButton GraphicsCardButton;
    private javax.swing.JLabel GraphicsCardLogo;
    private javax.swing.JPanel GraphicsCardPanel;
    private javax.swing.JTextField GraphicsCardTextField;
    private javax.swing.JCheckBox GraphicsNo1;
    private javax.swing.JCheckBox GraphicsYes1;
    private javax.swing.JButton HDCartRow1;
    private javax.swing.JButton HDCartRow2;
    private javax.swing.JButton HDCartRow3;
    private javax.swing.JButton HDCartRow4;
    private javax.swing.JButton HDCartRow5;
    private javax.swing.JButton HDCartRow6;
    private javax.swing.JButton HDCartRow7;
    private javax.swing.JButton HDCartRow8;
    private javax.swing.JButton HDRateRow1;
    private javax.swing.JButton HDRateRow2;
    private javax.swing.JButton HDRateRow3;
    private javax.swing.JButton HDRateRow4;
    private javax.swing.JButton HDRateRow5;
    private javax.swing.JButton HDRateRow6;
    private javax.swing.JButton HDRateRow7;
    private javax.swing.JButton HDRateRow8;
    private javax.swing.JButton HDRefresh;
    private javax.swing.JScrollPane HDScrollPane;
    private javax.swing.JButton HardDiskButton;
    private javax.swing.JLabel HardDiskLogo;
    private javax.swing.JPanel HardDiskPanel1;
    private javax.swing.JTextField HardDiskTextField;
    private javax.swing.JCheckBox Home1;
    private javax.swing.JPanel InternalHDDPanel;
    private javax.swing.JPanel KPanel;
    private javax.swing.JButton KeyboardButton;
    private javax.swing.JPanel KeyboardPane1;
    private javax.swing.JPanel KeyboardPanel;
    private javax.swing.JButton KeyboardRefresh;
    private javax.swing.JButton KeyboardRefresh1;
    private javax.swing.JTextField KeyboardTextField;
    private javax.swing.JScrollPane KeyboardrScrollPane;
    private javax.swing.JLabel L1Label;
    private javax.swing.JLabel L1Label1;
    private javax.swing.JLabel L1Label2;
    private javax.swing.JLabel L1Label3;
    private javax.swing.JLabel L1Label4;
    private javax.swing.JLabel LogoNameLabel;
    private javax.swing.JButton MBCartRow1;
    private javax.swing.JButton MBCartRow10;
    private javax.swing.JButton MBCartRow11;
    private javax.swing.JButton MBCartRow2;
    private javax.swing.JButton MBCartRow3;
    private javax.swing.JButton MBCartRow4;
    private javax.swing.JButton MBCartRow5;
    private javax.swing.JButton MBCartRow6;
    private javax.swing.JButton MBCartRow7;
    private javax.swing.JButton MBCartRow8;
    private javax.swing.JButton MBCartRow9;
    private javax.swing.JButton MBRateRow1;
    private javax.swing.JButton MBRateRow10;
    private javax.swing.JButton MBRateRow11;
    private javax.swing.JButton MBRateRow2;
    private javax.swing.JButton MBRateRow3;
    private javax.swing.JButton MBRateRow4;
    private javax.swing.JButton MBRateRow5;
    private javax.swing.JButton MBRateRow6;
    private javax.swing.JButton MBRateRow7;
    private javax.swing.JButton MBRateRow8;
    private javax.swing.JButton MBRateRow9;
    private javax.swing.JScrollPane MBScrollPane1;
    private javax.swing.JPanel MPanel;
    private javax.swing.JLabel MainLogoLabel;
    private javax.swing.JTextField MaxP1;
    private javax.swing.JTextField MinP1;
    private javax.swing.JPanel MoPanel;
    private javax.swing.JButton MonCartRow1;
    private javax.swing.JButton MonCartRow10;
    private javax.swing.JButton MonCartRow11;
    private javax.swing.JButton MonCartRow12;
    private javax.swing.JButton MonCartRow13;
    private javax.swing.JButton MonCartRow14;
    private javax.swing.JButton MonCartRow15;
    private javax.swing.JButton MonCartRow16;
    private javax.swing.JButton MonCartRow17;
    private javax.swing.JButton MonCartRow2;
    private javax.swing.JButton MonCartRow3;
    private javax.swing.JButton MonCartRow4;
    private javax.swing.JButton MonCartRow5;
    private javax.swing.JButton MonCartRow6;
    private javax.swing.JButton MonCartRow7;
    private javax.swing.JButton MonCartRow8;
    private javax.swing.JButton MonCartRow9;
    private javax.swing.JButton MonRateRow1;
    private javax.swing.JButton MonRateRow10;
    private javax.swing.JButton MonRateRow11;
    private javax.swing.JButton MonRateRow12;
    private javax.swing.JButton MonRateRow13;
    private javax.swing.JButton MonRateRow14;
    private javax.swing.JButton MonRateRow15;
    private javax.swing.JButton MonRateRow16;
    private javax.swing.JButton MonRateRow17;
    private javax.swing.JButton MonRateRow2;
    private javax.swing.JButton MonRateRow3;
    private javax.swing.JButton MonRateRow4;
    private javax.swing.JButton MonRateRow5;
    private javax.swing.JButton MonRateRow6;
    private javax.swing.JButton MonRateRow7;
    private javax.swing.JButton MonRateRow8;
    private javax.swing.JButton MonRateRow9;
    private javax.swing.JButton MonitorButton;
    private javax.swing.JPanel MonitorPane1;
    private javax.swing.JPanel MonitorPanel;
    private javax.swing.JButton MonitorRefresh;
    private javax.swing.JScrollPane MonitorScrollPane;
    private javax.swing.JTextField MonitorTextField;
    private javax.swing.JButton MotherBoardButton;
    private javax.swing.JLabel MotherBoardLabel;
    private javax.swing.JPanel MotherboardPanel;
    private javax.swing.JPanel MotherboardPanel1;
    private javax.swing.JTextField MotherboardTextField;
    private javax.swing.JButton MouseButton;
    private javax.swing.JButton MouseCartRow1;
    private javax.swing.JButton MouseCartRow10;
    private javax.swing.JButton MouseCartRow11;
    private javax.swing.JButton MouseCartRow12;
    private javax.swing.JButton MouseCartRow13;
    private javax.swing.JButton MouseCartRow2;
    private javax.swing.JButton MouseCartRow3;
    private javax.swing.JButton MouseCartRow4;
    private javax.swing.JButton MouseCartRow5;
    private javax.swing.JButton MouseCartRow6;
    private javax.swing.JButton MouseCartRow7;
    private javax.swing.JButton MouseCartRow8;
    private javax.swing.JButton MouseCartRow9;
    private javax.swing.JPanel MousePane1;
    private javax.swing.JPanel MousePanel;
    private javax.swing.JButton MouseRateRow1;
    private javax.swing.JButton MouseRateRow10;
    private javax.swing.JButton MouseRateRow11;
    private javax.swing.JButton MouseRateRow12;
    private javax.swing.JButton MouseRateRow13;
    private javax.swing.JButton MouseRateRow2;
    private javax.swing.JButton MouseRateRow3;
    private javax.swing.JButton MouseRateRow4;
    private javax.swing.JButton MouseRateRow5;
    private javax.swing.JButton MouseRateRow6;
    private javax.swing.JButton MouseRateRow7;
    private javax.swing.JButton MouseRateRow8;
    private javax.swing.JButton MouseRateRow9;
    private javax.swing.JTextField MouseTextField;
    private javax.swing.JScrollPane MouserScrollPane;
    private javax.swing.JLabel NameLogo1;
    private javax.swing.JLabel NameLogo10;
    private javax.swing.JLabel NameLogo11;
    private javax.swing.JLabel NameLogo12;
    private javax.swing.JLabel NameLogo13;
    private javax.swing.JLabel NameLogo14;
    private javax.swing.JLabel NameLogo15;
    private javax.swing.JLabel NameLogo16;
    private javax.swing.JLabel NameLogo2;
    private javax.swing.JLabel NameLogo3;
    private javax.swing.JLabel NameLogo4;
    private javax.swing.JLabel NameLogo5;
    private javax.swing.JLabel NameLogo6;
    private javax.swing.JLabel NameLogo7;
    private javax.swing.JLabel NameLogo8;
    private javax.swing.JLabel NameLogo9;
    private javax.swing.JPanel NamePanel;
    private javax.swing.JCheckBox Office1;
    private javax.swing.JButton PCartRow1;
    private javax.swing.JButton PCartRow10;
    private javax.swing.JButton PCartRow11;
    private javax.swing.JButton PCartRow12;
    private javax.swing.JButton PCartRow13;
    private javax.swing.JButton PCartRow14;
    private javax.swing.JButton PCartRow15;
    private javax.swing.JButton PCartRow16;
    private javax.swing.JButton PCartRow17;
    private javax.swing.JButton PCartRow18;
    private javax.swing.JButton PCartRow19;
    private javax.swing.JButton PCartRow2;
    private javax.swing.JButton PCartRow20;
    private javax.swing.JButton PCartRow21;
    private javax.swing.JButton PCartRow22;
    private javax.swing.JButton PCartRow23;
    private javax.swing.JButton PCartRow24;
    private javax.swing.JButton PCartRow25;
    private javax.swing.JButton PCartRow26;
    private javax.swing.JButton PCartRow3;
    private javax.swing.JButton PCartRow4;
    private javax.swing.JButton PCartRow5;
    private javax.swing.JButton PCartRow6;
    private javax.swing.JButton PCartRow7;
    private javax.swing.JButton PCartRow8;
    private javax.swing.JButton PCartRow9;
    private javax.swing.JButton PRateRow1;
    private javax.swing.JButton PRateRow10;
    private javax.swing.JButton PRateRow11;
    private javax.swing.JButton PRateRow12;
    private javax.swing.JButton PRateRow13;
    private javax.swing.JButton PRateRow14;
    private javax.swing.JButton PRateRow15;
    private javax.swing.JButton PRateRow16;
    private javax.swing.JButton PRateRow17;
    private javax.swing.JButton PRateRow18;
    private javax.swing.JButton PRateRow19;
    private javax.swing.JButton PRateRow2;
    private javax.swing.JButton PRateRow20;
    private javax.swing.JButton PRateRow21;
    private javax.swing.JButton PRateRow22;
    private javax.swing.JButton PRateRow23;
    private javax.swing.JButton PRateRow24;
    private javax.swing.JButton PRateRow25;
    private javax.swing.JButton PRateRow26;
    private javax.swing.JButton PRateRow3;
    private javax.swing.JButton PRateRow4;
    private javax.swing.JButton PRateRow5;
    private javax.swing.JButton PRateRow6;
    private javax.swing.JButton PRateRow7;
    private javax.swing.JButton PRateRow8;
    private javax.swing.JButton PRateRow9;
    private javax.swing.JButton PSCartRow1;
    private javax.swing.JButton PSCartRow10;
    private javax.swing.JButton PSCartRow11;
    private javax.swing.JButton PSCartRow12;
    private javax.swing.JButton PSCartRow13;
    private javax.swing.JButton PSCartRow14;
    private javax.swing.JButton PSCartRow15;
    private javax.swing.JButton PSCartRow16;
    private javax.swing.JButton PSCartRow17;
    private javax.swing.JButton PSCartRow18;
    private javax.swing.JButton PSCartRow19;
    private javax.swing.JButton PSCartRow2;
    private javax.swing.JButton PSCartRow20;
    private javax.swing.JButton PSCartRow21;
    private javax.swing.JButton PSCartRow22;
    private javax.swing.JButton PSCartRow3;
    private javax.swing.JButton PSCartRow4;
    private javax.swing.JButton PSCartRow5;
    private javax.swing.JButton PSCartRow6;
    private javax.swing.JButton PSCartRow7;
    private javax.swing.JButton PSCartRow8;
    private javax.swing.JButton PSCartRow9;
    private javax.swing.JButton PSRefresh;
    private javax.swing.JButton PowerSupplyButton;
    private javax.swing.JLabel PowerSupplyLogo;
    private javax.swing.JPanel PowerSupplyPanel;
    private javax.swing.JPanel PowerSupplyPanel1;
    private javax.swing.JScrollPane PowerSupplyScrollPane;
    private javax.swing.JTextField PowerSupplyTextField;
    private javax.swing.JButton ProcessorButton;
    private javax.swing.JLabel ProcessorLogo;
    private javax.swing.JPanel ProcessorPanel;
    private javax.swing.JPanel ProcessorPanel1;
    private javax.swing.JButton ProcessorRefesh;
    private javax.swing.JButton ProcessorRefesh1;
    private javax.swing.JScrollPane ProcessorScrollPane;
    private javax.swing.JTextField ProcessorTextField;
    private javax.swing.JButton PsRateRow1;
    private javax.swing.JButton PsRateRow10;
    private javax.swing.JButton PsRateRow11;
    private javax.swing.JButton PsRateRow12;
    private javax.swing.JButton PsRateRow13;
    private javax.swing.JButton PsRateRow14;
    private javax.swing.JButton PsRateRow15;
    private javax.swing.JButton PsRateRow16;
    private javax.swing.JButton PsRateRow17;
    private javax.swing.JButton PsRateRow18;
    private javax.swing.JButton PsRateRow19;
    private javax.swing.JButton PsRateRow2;
    private javax.swing.JButton PsRateRow20;
    private javax.swing.JButton PsRateRow21;
    private javax.swing.JButton PsRateRow22;
    private javax.swing.JButton PsRateRow3;
    private javax.swing.JButton PsRateRow4;
    private javax.swing.JButton PsRateRow5;
    private javax.swing.JButton PsRateRow6;
    private javax.swing.JButton PsRateRow7;
    private javax.swing.JButton PsRateRow8;
    private javax.swing.JButton PsRateRow9;
    private javax.swing.JLabel RAMLogo;
    private javax.swing.JPanel RAMPanel1;
    private javax.swing.JButton RAMRateRow1;
    private javax.swing.JButton RAMRateRow10;
    private javax.swing.JButton RAMRateRow11;
    private javax.swing.JButton RAMRateRow12;
    private javax.swing.JButton RAMRateRow13;
    private javax.swing.JButton RAMRateRow14;
    private javax.swing.JButton RAMRateRow15;
    private javax.swing.JButton RAMRateRow16;
    private javax.swing.JButton RAMRateRow2;
    private javax.swing.JButton RAMRateRow3;
    private javax.swing.JButton RAMRateRow4;
    private javax.swing.JButton RAMRateRow5;
    private javax.swing.JButton RAMRateRow6;
    private javax.swing.JButton RAMRateRow7;
    private javax.swing.JButton RAMRateRow8;
    private javax.swing.JButton RAMRateRow9;
    private javax.swing.JButton RAMRefesh;
    private javax.swing.JButton RAMRefesh1;
    private javax.swing.JScrollPane RAMScrollPane;
    private javax.swing.JButton RamButton;
    private javax.swing.JButton RamCartRow1;
    private javax.swing.JButton RamCartRow10;
    private javax.swing.JButton RamCartRow11;
    private javax.swing.JButton RamCartRow12;
    private javax.swing.JButton RamCartRow13;
    private javax.swing.JButton RamCartRow14;
    private javax.swing.JButton RamCartRow15;
    private javax.swing.JButton RamCartRow16;
    private javax.swing.JButton RamCartRow2;
    private javax.swing.JButton RamCartRow3;
    private javax.swing.JButton RamCartRow4;
    private javax.swing.JButton RamCartRow5;
    private javax.swing.JButton RamCartRow6;
    private javax.swing.JButton RamCartRow7;
    private javax.swing.JButton RamCartRow8;
    private javax.swing.JButton RamCartRow9;
    private javax.swing.JPanel RamPanel;
    private javax.swing.JTextField RamTextField;
    private javax.swing.JPanel SPanel;
    private javax.swing.JButton SSButton;
    private javax.swing.JButton SSCartRow1;
    private javax.swing.JButton SSCartRow10;
    private javax.swing.JButton SSCartRow11;
    private javax.swing.JButton SSCartRow12;
    private javax.swing.JButton SSCartRow13;
    private javax.swing.JButton SSCartRow2;
    private javax.swing.JButton SSCartRow3;
    private javax.swing.JButton SSCartRow4;
    private javax.swing.JButton SSCartRow5;
    private javax.swing.JButton SSCartRow7;
    private javax.swing.JButton SSCartRow8;
    private javax.swing.JButton SSCartRow9;
    private javax.swing.JCheckBox SSNo1;
    private javax.swing.JPanel SSPane1;
    private javax.swing.JPanel SSPanel;
    private javax.swing.JButton SSRateRow1;
    private javax.swing.JButton SSRateRow10;
    private javax.swing.JButton SSRateRow11;
    private javax.swing.JButton SSRateRow12;
    private javax.swing.JButton SSRateRow13;
    private javax.swing.JButton SSRateRow2;
    private javax.swing.JButton SSRateRow3;
    private javax.swing.JButton SSRateRow4;
    private javax.swing.JButton SSRateRow5;
    private javax.swing.JButton SSRateRow6;
    private javax.swing.JButton SSRateRow7;
    private javax.swing.JButton SSRateRow8;
    private javax.swing.JButton SSRateRow9;
    private javax.swing.JButton SSRefresh;
    private javax.swing.JButton SSRow6;
    private javax.swing.JTextField SSTextField;
    private javax.swing.JCheckBox SSYes1;
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JPanel SearchPanel2;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JPanel SoundSystemPanel;
    private javax.swing.JScrollPane SoundSystemScrollPane;
    private javax.swing.JButton SugestionConfirm1;
    private javax.swing.JScrollPane SuggestionScrollPane;
    private javax.swing.JPanel SuggestionShow;
    private javax.swing.JPanel SuggestionShow1;
    private javax.swing.JPanel SuggestionShowPane1;
    private javax.swing.JButton SuggestionsButton;
    private javax.swing.JPanel SuggestionsPanel;
    private javax.swing.JPanel TopSearchPanel;
    private javax.swing.JTextField TotalPriceField;
    private javax.swing.JButton UPSCartRow1;
    private javax.swing.JButton UPSCartRow2;
    private javax.swing.JButton UPSCartRow3;
    private javax.swing.JButton UPSCartRow4;
    private javax.swing.JButton UPSCartRow5;
    private javax.swing.JButton UPSCartRow6;
    private javax.swing.JCheckBox UPSNo1;
    private javax.swing.JPanel UPSPane1;
    private javax.swing.JButton UPSRateRow1;
    private javax.swing.JButton UPSRateRow2;
    private javax.swing.JButton UPSRateRow3;
    private javax.swing.JButton UPSRateRow4;
    private javax.swing.JButton UPSRateRow5;
    private javax.swing.JButton UPSRateRow6;
    private javax.swing.JButton UPSRefresh;
    private javax.swing.JScrollPane UPSScrollPane;
    private javax.swing.JTextField UPSTextField;
    private javax.swing.JCheckBox UPSYes1;
    private javax.swing.JPanel UPanel;
    private javax.swing.JButton UpsButton;
    private javax.swing.JPanel UpsPanel;
    private javax.swing.JTable jCasingTable;
    private javax.swing.JTable jGCardTable;
    private javax.swing.JTable jHardDiskTable;
    private javax.swing.JTable jKeyboardTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jMonitorTable;
    private javax.swing.JTable jMotherboardTable;
    private javax.swing.JTable jMouseTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTable jPowerSupplyTable;
    private javax.swing.JTable jProcessorTable;
    private javax.swing.JTable jRAMTable;
    private javax.swing.JTable jSSTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jSearchTable;
    private javax.swing.JTable jUPSTable;
    private javax.swing.JButton keyCartRow1;
    private javax.swing.JButton keyCartRow2;
    private javax.swing.JButton keyCartRow3;
    private javax.swing.JButton keyCartRow4;
    private javax.swing.JButton keyCartRow5;
    private javax.swing.JButton keyCartRow6;
    private javax.swing.JButton keyCartRow7;
    private javax.swing.JButton keyCartRow8;
    private javax.swing.JButton keyCartRow9;
    private javax.swing.JButton keyRateRow1;
    private javax.swing.JButton keyRateRow2;
    private javax.swing.JButton keyRateRow3;
    private javax.swing.JButton keyRateRow4;
    private javax.swing.JButton keyRateRow5;
    private javax.swing.JButton keyRateRow6;
    private javax.swing.JButton keyRateRow7;
    private javax.swing.JButton keyRateRow8;
    private javax.swing.JButton keyRateRow9;
    // End of variables declaration//GEN-END:variables
}

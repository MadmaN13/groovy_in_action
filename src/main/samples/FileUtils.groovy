package samples

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger("LOGFILE");

    static Map<?,?> findLineInDir(File dir, String line) {
        def inDir = [:]
        if (dir.isDirectory()) {
            def size = dir.list().size()
            def counter = 1
            dir.eachFile {
                logger.info("Processing $counter file out of $size");
                def inFile = findLineInFile(it, line)
                if (inDir.containsKey(it.getName())) {
                    def oldEntries = inDir.get(it.getName())
                    inFile.addAll(oldEntries)
                }
                inDir[it.getName()] = inFile
                counter++
            }
        }
        inDir
    }

    static List<String> findLineInFile(File file, String line) {
        def entries = []
        file.eachLine {
            if (it.contains(line)) entries.add(it)
        }
        entries
    }

    public static void main(String[] args) {
        def testDir = "C:\\Users\\NM.Rabotaev\\Desktop\\skb\\фл\\поддержка\\iss2707_no_session\\archive";
        def toFind = "176.9.136.47";
        def results = FileUtils.findLineInDir(new File(testDir), toFind);
        results.each {
            if (it.getValue()) {
                def filename = it.getKey()
                def entries = it.getValue()
                logger.info(filename);
                entries.each {logger.info(it)}
                logger.info("-------------------------------------------------------------------------------------------------------");
            }
        }
    }
}

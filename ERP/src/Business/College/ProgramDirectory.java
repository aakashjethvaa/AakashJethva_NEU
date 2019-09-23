/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.College;

import java.util.ArrayList;

/**
 *
 * @author krunal
 */
public class ProgramDirectory {

    private ArrayList<Program> directory;

    public ProgramDirectory() {
        directory = new ArrayList<Program>();
    }

    public Program createProgram(String name) {
        Program prg = new Program(name);
        directory.add(prg);
        return prg;

    }

    public void removeProgram(Program prg) {
        directory.remove(prg);
    }

    public ArrayList<Program> getDirectory() {
        return directory;
    }

    public void setDirectory(ArrayList<Program> directory) {
        this.directory = directory;
    }

}

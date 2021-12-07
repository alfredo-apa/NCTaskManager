package mx.edu.j2se.aparicio.tasks;

public class ArrayTaskList {
    Tasks[] arrayTask;

    /**
     * Adds a task to the array,
     * initializing it, in the
     * case the array is empty
     * or adding a space to add
     * the task.
     *
     * This method calls
     * changeSize, with a zero
     * as the action parameter
     * and -1 as index for it
     * to be ignored, to resize
     * the array to add the task.
     *
     * @param task
     */
    void add(Tasks task){
        this.changeSize(0, -1);
        arrayTask[this.size()-1] = task;
    }
    /**
     * Removes the desired task
     * from the current array,
     * emptying and assigning
     * null to the array in case
     * it has one task assigned,
     * if the length of the array
     * is more than one this
     * method will verify if the
     * task is in the array to
     * get the task index to
     * remove it.
     *
     * The method returns true
     * if the operation could be
     * completed and false if
     * not.
     *
     * This method calls
     * changeSize, with a zero
     * as the action parameter
     * and -1 as index for it
     * to be ignored, to resize
     * the array to add the task.
     *
     * @param task
     * @return
     */
    boolean remove(Tasks task){
        boolean flag = false;
        int index = 0;

        try {
            if (this.size() == 1 && task.equals(arrayTask[0])) {
                arrayTask = null;
                flag = true;
            } else {
                while (flag == false) {
                    if (task.equals(arrayTask[index])) {
                        flag = true;
                        this.changeSize(1, index);
                    } else {
                        index++;
                    }
                }
            }
            return flag;
        }catch (Exception e){
            throw e;
        }

    }
    /**
     * Returns the size of
     * the array calling
     * the array.length
     * method.
     *
     * @return
     */
    int size(){

        return arrayTask.length;
    }
    /**
     * Returns the task of the
     * given index, in case the
     * index is not valid the
     * function will return the
     * default error.
     *
     * @param index
     * @return
     */
    Tasks getTask(int index) throws Exception{
        try {
            return arrayTask[index];
        }catch (Exception e){
            throw new Exception(
                    "Non Existing Index."
            );
        }

    }

    /**
     * Creates an ArrayTaskList
     * object with the tasks that
     * starts between the
     * specified hours (starting
     * hour: from, ending hour: to).
     *
     * In case there are no tasks
     * between the assigned hours or
     * the from parameter is an hour
     * after the hour assigned to the
     * to parameter the function will
     * throw an empty ArrayTaskList
     * object.
     *
     * @param from
     * @param to
     * @return
     */
    ArrayTaskList incoming(int from, int to) throws Exception {

        ArrayTaskList a = new ArrayTaskList();
        if (to>from) {
            for (Tasks t : this.arrayTask) {
                if (t.isActive() && t.startTime > from && t.startTime > to) {
                    a.add(t);
                }
            }
        }else{
            throw new Exception(
                    "The time values are valid."
            );
        }

        return a;
    }

    /**
     * Changes the size of the array
     * by one, adding or subtracting
     * one index space. In the case
     * the array is empty this method
     * will initialize it giving one
     * index space (array length: 1).
     *
     * The action parameter is ask for
     * the function to know if it needs
     * to subtract or add an index in
     * the array.
     *
     * @param action
     * @param index
     */
    private void changeSize(int action, int index){
        try{
            int i = this.size();

            Tasks[] aux = new Tasks[i];
            aux = arrayTask;
            switch(action){
                case 0:
                    arrayTask = new Tasks[i+1];
                    for ( i =0; i < arrayTask.length; i++){
                        arrayTask[i] = aux[i];
                    }
                    break;
                case 1:
                    arrayTask = new Tasks[i-1];
                    for ( i =0; i < arrayTask.length; i++){
                        int j = 0;
                        if(j == index){
                            j++;
                        }
                        arrayTask[i] = aux[j];
                        j++;
                    }
                    break;
            }


        }catch (Exception e){
            arrayTask = new Tasks[1];
        }

    }


}

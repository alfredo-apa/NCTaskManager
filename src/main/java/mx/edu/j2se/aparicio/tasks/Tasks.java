package mx.edu.j2se.aparicio.tasks;

public class Tasks {

    int origin_time = 0; // TODO: 10/11/2021 Use in next version.
    String taskTitle;
    int startTime, endTime = -1, taskInterval = -1;
    boolean active = false;

    /**
     * Creates a non repetitive task,
     * asking for its title and starting
     * time as parameters.
     *
     * The title must be introduced as a
     * String, if there are other values,
     * the given title will take them as
     * a String.
     *
     * The given time must be introduced
     * as an integer (int), representing
     * the hours from the zero hour to
     * the assigned hour given to the
     * task.
     *
     * @param title
     * @param time
     */
    Tasks(String title, int time) throws Exception{
        if (time < 0){
            throw new Exception(
                "El valor de la(s) hora(s) no puede ser negativo." +
                        "\nThe hour value cannot be negative."
            );
        }else{
            taskTitle = title;
            startTime = time;
        }

    }
    /**
     * Creates a repetitive task, asking
     * for its title, starting and ending
     * time, and the interval between
     * instances as parameters.
     *
     * The title must be introduced as a
     * String, if there are other values,
     * the given title will take them as
     * a String.
     *
     * The given time must be introduced
     * as an integer (int), representing
     * the hours from the zero hour to
     * the assigned starting or ending
     * hour given to the task.
     *
     * The given interval must be
     * introduced as an integer (int),
     * representing the number of hours
     * between each of the instances of
     * the task.
     *
     * @param title
     * @param start
     * @param end
     * @param interval
     */
    Tasks(String title, int start, int end, int interval) throws Exception{
        if (start < 0 || end < start || interval < 0){
            throw new Exception(
                    "El valor de la(s) hora(s) no puede ser negativo." +
                            "\nThe hour value cannot be negative."
            );
        }else if(end == start || interval == 0) {
            throw new Exception(
                    "Los valores introducidos no corresponden a una tarea repetitiva." +
                            "\nThe given values are not the ones needed for a repetitive task."
            );
        }else{
            taskTitle = title;
            startTime = start;
            endTime = end;
            taskInterval = interval;
        }
    }
    /**
     * Verifies and returns the title
     * of the active task.
     *
     * @return
     */
    String getTitle(){
        String title = taskTitle;

        // TODO: 10/11/2021 Use in next version
        /*if (!this.isActive())
            title = "No active task";*/

        return title;
    }
    /**
     *Changes the title of the
     *current task.
     *
     *The title must be given as
     *a String, any other value
     * will be considered as a
     * String.
     *
     * @param title
     */
    void setTitle(String title){
        taskTitle = title;
    }
    /**
     * Verifies if the current
     * task is active, returning
     * a boolean as a result.
     *
     * @return
     */
    boolean isActive(){
        return active;
    }
    /**
     *Changes the active state
     * of the current task.
     *
     * Receives a boolean or in
     * some cases the parameter
     * could be replaced with 1
     * (true / active) or 0
     * (false / not active)
     *
     * @param flag
     */ // TODO: 10/11/2021 Verify if boolean in java accepts 1/0 as parameters.
    void setActive(boolean flag){
        active = flag;
    }
    /**
     * Checks the starting time
     * of the next iteration of
     * the current task,
     * regardless if it is
     * repetitive or not.
     *
     * This function returns the
     * hour that represents the
     * starting time of the
     * current task as an int.
     *
     * @return
     */
    int getTime(int current){
        int time = 0;
        if(this.isRepeated()){
            time = this.nextTimeAfter(current);
        }else{
            time = startTime;
        }
        return time;
    }
    /**
     * This function sets the starting
     * time for the current task. The
     * function asks and integer
     * representing the new starting
     * hour for the current task.
     *
     * If the task is repetitive, it
     * will become non repetitive. In
     * the case that the task is a
     * repetitive, the ending time and
     * interval variables will get the
     * -1 value.
     *
     * @param time
     */
    void setTime(int time){
        if(this.isRepeated()){
            endTime = -1;
            taskInterval = -1;
        }
        startTime = time;
    }
    /**
     * Checks the starting hour
     * of the first iteration of
     * the task if repetitive or
     * the starting time if non
     * repetitive.
     *
     * @return
     */
    int getStartTime(){
        return startTime;
    }
    /**
     *Verifies if the current task
     * is repetitive, if the case,
     * it returns the time for the
     * last iteration of the
     * current task. In the case
     * that the task is
     * non repetitive, the function
     * will return a 404 value.
     *
     * @return
     */ // TODO: 12/11/2021 Change the last part after completing the objective of the to do inside this function.
    int getEndTime(){
        int time = 0;
        if(!this.isRepeated()){
            time = endTime;
        }else{
            time = 404; // TODO: 12/11/2021 Verify variable to change joke for something relevant.
        }
        return time;
    }
    /**
     * Checks the interval of
     * the current task, if
     * the task is a non
     * repetitive this method
     * will return the default
     * value of the interval
     * (-1).
     *
     * @return
     */
    int getRepeatInterval(){
        return taskInterval;
    }
    /**
     * Changes the interval of
     * the current task, this
     * method only works if the
     * tasks is repetitive, on
     * the contrary it'll do
     * nothing.
     *
     * In the case that the given
     * interval is higher than the
     * time between the first and
     * last interval, the assigned
     * interval will be the
     * difference of hours between
     * the starting time and the
     * ending time of the task.
     *
     * @param start
     * @param end
     * @param interval
     */
    void setInterval(int start, int end, int interval){

        if (this.isRepeated()){
            startTime = start;

            if (interval < (end - start)){
                endTime = end;
                taskInterval = interval;
            }else {
                endTime = end;
                taskInterval = end - start;
            }
        }
    }
    /**
     * Verifies if the current
     * task is a repetitive or
     * not, checking if there
     * is a time interval
     * assigned to the current
     * task.
     *
     * @return
     */
    boolean isRepeated(){
        boolean flag = false;

        if (taskInterval != -1) {
            flag = true;
        }

        return flag;
    }
    /**
     * This method searches for
     * the next iteration of the
     * current task, given the
     * current time as a
     * parameter, if the task is
     * active and repetitive.
     *
     * In the case the task
     * doesn't fulfil the
     * requirements, the method
     * will return -1. In case it
     * fulfil the starting
     * requirements (being active
     * and repetitive), the
     * method will check if there
     * is an iteration after the
     * current time. If there is
     * no next iteration the
     * method will return -1.
     *
     * @param current
     * @return
     */
    int nextTimeAfter(int current){
        int next = 0;

        if(active == true){
            if(current > startTime && current < endTime) {
                int i = startTime;

                while(i<current){
                    i =+ taskInterval;
                    if (i>current){
                        next = i;
                    }
                }
            }else if (current < startTime) {
                next = startTime;
            }else{
                next = -1;
            }
        }else{
            next = -1;
        }

        return next;
    }
    void setTime(int start, int end, int interval){
        startTime = start;
        endTime = end;
        taskInterval = interval;
    }

}
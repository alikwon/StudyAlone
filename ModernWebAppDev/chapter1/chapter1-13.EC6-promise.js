{
    function getProjects(callback) {
        console.log('getProjects')
        let projects = [
            { id: 1, name: "Project A" },
            { id: 2, name: "Project B" },
        ];
        callback(projects);
    }
    
    function getTasks(projects, callback) {
        console.log('getTasks')
        let tasks = [
            { id: 1, projectId: 1, title: "Task A" },
            { id: 2, projectId: 2, title: "Task B" },
        ];
        callback(tasks);
    }
    
    function render({ projects, tasks }) {
        console.log(
            `Render ${projects.length} projects and ${tasks.length} tasks`
            );
        }
        
    //callback hell
    getProjects((projects) => {
        getTasks(projects, (tasks) => {
            render({ projects, tasks });
        });
    });
}
    
/*=============================================================================
프로미스 활용       */
{
    function getProjects() {
        console.log('getProjects')
        let projects = [
            { id: 1, name: "Project A" },
            { id: 2, name: "Project B" },
        ];
        return new Promise((resolve, reject) => {
            resolve(projects);
        });
    }
    
    function getTasks(projects) {
        console.log('getTasks')
        return new Promise((resolve, reject) => {
            resolve({ 
                projects, 
                tasks: ["Buy three tickets", "Book a hotel"] 
            });
        });
    }

    function render({projects, tasks}) {
        console.log(
            `Render ${projects.length} projects and ${tasks.length} tasks`
        );
    }

    getProjects()
        .then(getTasks)
        .then(render)
        .catch((error) =>{
            console.log('Handling error',error);
        });
}

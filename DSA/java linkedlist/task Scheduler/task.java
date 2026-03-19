class TaskNode:
    def __init__(self, task_id, name, priority, due_date):
        self.task_id, self.name, self.priority, self.due_date = task_id, name, priority, due_date
        self.next = None

class CircularTaskScheduler:
    def __init__(self):
        self.head = None
        self.current = None

    def add_task(self, task_id, name, priority, due_date):
        new_node = TaskNode(task_id, name, priority, due_date)
        if not self.head:
            self.head = new_node
            self.head.next = self.head
        else:
            curr = self.head
            while curr.next != self.head:
                curr = curr.next
            curr.next = new_node
            new_node.next = self.head

    def view_and_move_next(self):
        if not self.head: return None
        if not self.current: self.current = self.head
        task = self.current
        self.current = self.current.next
        return task

    def display_all(self):
        if not self.head: return
        curr = self.head
        while True:
            print(f"Task {curr.task_id}: {curr.name} [Priority: {curr.priority}]")
            curr = curr.next
            if curr == self.head: break
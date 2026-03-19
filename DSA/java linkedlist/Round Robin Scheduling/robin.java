class ProcessNode:
    def __init__(self, pid, burst_time, priority):
        self.pid = pid
        self.burst_time = burst_time
        self.priority = priority
        self.remaining_time = burst_time
        self.next = None

class RoundRobinScheduler:
    def __init__(self, quantum):
        self.head = None
        self.quantum = quantum

    def add_process(self, pid, burst_time, priority):
        new_node = ProcessNode(pid, burst_time, priority)
        if not self.head:
            self.head = new_node
            self.head.next = self.head
        else:
            curr = self.head
            while curr.next != self.head:
                curr = curr.next
            curr.next = new_node
            new_node.next = self.head

    def simulate(self):
        if not self.head: return
        curr = self.head
        while self.head: # Runs until all processes finish
            if curr.remaining_time > 0:
                execute_time = min(curr.remaining_time, self.quantum)
                curr.remaining_time -= execute_time
                print(f"Process {curr.pid} executed for {execute_time}. Remaining: {curr.remaining_time}")
                
            if curr.remaining_time == 0:
                self.remove_process(curr.pid) # Logic to safely remove and update pointers
                if not self.head: break
            curr = curr.next
            
    def remove_process(self, pid):
        # Implementation to remove a process from circular loop and update head if necessary
        pass
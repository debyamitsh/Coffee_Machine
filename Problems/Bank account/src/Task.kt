class BankAccount {
    val deposited: Long
    val withdrawn: Long
    val balance: Long

    constructor(deposited: Long, withdrawn: Long) {
        this.deposited = deposited
        this.withdrawn = withdrawn
        this.balance = deposited - withdrawn
    }
}

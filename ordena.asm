sort:
	addi $sp, $sp, -20
	sw $ra, 16($sp)
	sw $s3, 12($sp)
	sw $s2, 8($sp)
	sw $s1, 4($sp)
	sw $s0, 0($sp)
	
	add $s2, $a0, $zero
	add $s3, $a1, $zero
	add $s0, $zero, $zero

for1tst:
	slt $t0, $s0, $s3
	beq $t0, $zero, exit1
	addi $s1, $s0, -1
for2tst: 
	slti $t0, $s1, 0
	bne $t0, $zero, exit2
	mul $t1, $s1, 44
	add $t2, $s2, $t1
	
	la $a1, ABASTECIMENTOS
	
	jal somaData
	add $t3, $v0, $zero
	jal somaData
	add $t4, $v0, $zero
	
	slt $t0, $t4, $t3	
	beq $t0, $zero, exit2
	add $a0, $s2, $zero
	add $a1, $s1, $zero
	jal swap
	addi $s1, $s1, -1
	j for2tst

exit2:
	addi $s0, $s0, 1
	j for1tst
	
exit1: 
	lw $s0, 0($sp)
	lw $s1, 4($sp)
	lw $s2, 8($sp)
	lw $s3, 12($sp)
	lw $ra, 16($sp)
	addi $sp, $sp, 20
	jr $ra
	
swap:
	sll $t1 $a1, 2
	add $t1, $a0, $t1
	
	#colocando na pilha
addi $sp, $sp, -4
lw $t0, 0($a1)
sw $t0, 0($sp)
addi $sp, $sp, -4
lw $t0, 4($a1)
sw $t0, 0($sp)
addi $sp, $sp, -4
lw $t0, 8($a1)
sw $t0, 0($sp)
addi $sp, $sp, -4
lw $t0, 12($a1)
sw $t0, 0($sp)
addi, $sp, $sp, -4
lw $t0, 16($a1)
sw $t0, 0($sp)
addi $sp, $sp, -4
l.s $f0, 20($a1)
s.s $f0, 0($sp)

# substituindo o i+1 por i
addi $a1, $a1, 24
lw $t0, 0($a1)

sw $t0, -24($a1)
lw $t0, 4($a1)

sw $t0, -20($a1)
lw $t0, 8($a1)

sw $t0, -16($a1)
lw $t0, 12($a1)
sw $t0, -12($a1)
lw $t0, 16($a1)
sw $t0, -8($a1)

l.s $f0, 20($a1)
s.s $f0, -4($a1)

# i+1 = pilha
l.s $f0, 0($sp)
s.s $f0, 20($a1)
addi $sp, $sp, 4
lw $t0, 0($sp)
sw $t0, 16($a1)
addi $sp, $sp, 4

lw $t0, 0($sp)
sw $t0, 12($a1)
addi $sp, $sp, 4
lw $t0, 0($sp)
sw $t0, 8($a1)
addi $sp, $sp, 4
lw $t0, 0($sp)
sw $t0, 4($a1)
addi $sp, $sp, 4
lw $t0, 0($sp)
sw $t0, 0($a1)
addi $sp, $sp, 4
j for1

	jr $ra
	
somaData:
	addi $sp, $sp, -8
	sw $ra, 4($sp)
	sw $s0, 0($sp)
	
	addi $t7,$zero,365
	addi $t6,$zero,30
	
	lb $t0, 3($a1) #carrega o ano em t0
	mul $t2, $t7, $t0 #multiplica por 365 o ano
	lb $t0, 2($a1) #carrega o mes em t0
	mul $t3, $t6, $t0 #t3 = 30*numero do mes
	add $t0, $t2, $t3 #t0 = t2(ano) + t3(mes)
	lb $t1, 1($a1) #carrega o dia em t1
	add $t0, $t1, $t0 
	#t0 = t1(dia) + t0(ano+mes) ======> t0 = a qtd de dias do cadastro
	add $v0, $zero, $t0
	
	lw $s0, 0($sp)
	lw $ra, 4($sp)
	addi $sp, $sp, 8
	jr $ra
	
